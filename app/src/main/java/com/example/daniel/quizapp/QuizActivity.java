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
    //*********TODO: have to see why i cant send the quiz instead of the questions. Once im done with the functional******************
    private Quiz quiz;
    private ArrayList<Question> questions;
    private TextView question;
    private HashMap<String,Boolean> answers = new HashMap<>();
    private ArrayList<Question> wrongAnswers = new ArrayList<>();
    private int index = 0;
    private int points = 0; // Soon to delete
    private int totalPoints = 0;// Soon to delete
    private TextView pointsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        questions  = getIntent().getParcelableArrayListExtra("runQuiz");
        question = findViewById(R.id.textView);
        initQuiz();
    }

    public void initQuiz(){
        for(Question ques: questions){
            totalPoints+=ques.getPoint();
        }
        question.setText(questions.get(0).getQuestion());

    }


    public void answered(View v){
       switch (v.getId()){
           case R.id.trueBTN:
               answers.put(questions.get(index).getQuestion(), true);
               nextQuestion();
               break;
           case R.id.falseBTN:
               answers.put(questions.get(index).getQuestion(), false);
               nextQuestion();
               break;
       }

    }

    public void nextQuestion(){

        if(index < questions.size() - 1){
            index++;
            question.setText(questions.get(index).getQuestion());
        }else{

            setContentView(R.layout.layout_results);
            endResults();
        }

    }

    private void endResults() {

        int[] index = new int[questions.size()];

        checkAnswers();
        displayWrong();


    }

    private void displayWrong() {

        CustomListQuestionAdapter questionList = new CustomListQuestionAdapter(this, this.questions, this.wrongAnswers);
        ListView listView = findViewById(R.id.list_results);
        listView.setAdapter(questionList);



    }

    public void checkAnswers(){

        pointsTxt = findViewById(R.id.points);

        for(Question ques: questions){
            if(ques.getAnswer() == answers.get(ques.getQuestion())){
                points+=ques.getPoint();
            }else{
                wrongAnswers.add(ques);
            }
        }

        String result = points+" / "+totalPoints;

        pointsTxt.setText("You Scored: " + result);

    }


}
