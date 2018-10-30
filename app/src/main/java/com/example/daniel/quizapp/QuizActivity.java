package com.example.daniel.quizapp;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class QuizActivity extends AppCompatActivity {

    private Quiz quiz;
    private ArrayList<Question> wrongAnswers = new ArrayList<>();
    private int index = 0;
    private TextView question;
    private TextView pointsTxt;
    private TextView quizName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        quiz = getIntent().getExtras().getParcelable("sampleQuiz");

        question = findViewById(R.id.textView);

        System.out.println(quiz.getName());

        initQuiz();
    }

    public void initQuiz(){


        question.setText(quiz.getQuestions().get(0).getQuestion());

    }


    public void answered(View v){
       boolean correct;
       switch (v.getId()){
           case R.id.trueBTN:

               correct = quiz.checkAnswer(index, true);
               if(!correct)this.wrongAnswers.add(quiz.getQuestions().get(index));
               nextQuestion();

               break;
           case R.id.falseBTN:
               correct = quiz.checkAnswer(index, false);
               if(!correct)this.wrongAnswers.add(quiz.getQuestions().get(index));
               nextQuestion();
               break;
       }

    }

    public void nextQuestion(){

        if(index < quiz.getQuestions().size() - 1){
            index++;
            question.setText(quiz.getQuestions().get(index).getQuestion());
        }else{


            endResults();
        }

    }

    private void endResults() {
        setContentView(R.layout.layout_results);

        pointsTxt = findViewById(R.id.points);
        quizName = findViewById(R.id.quizName);

        quizName.setText(""+quiz.getName());

        String result = quiz.getYourPoints() +" / "+ quiz.getTotalPoints();
        pointsTxt.setText("You Scored: " + result);

        CustomListQuestionAdapter questionList = new CustomListQuestionAdapter(this, quiz.getQuestions(), this.wrongAnswers);
        ListView listView = findViewById(R.id.list_results);
        listView.setAdapter(questionList);



    }

}
