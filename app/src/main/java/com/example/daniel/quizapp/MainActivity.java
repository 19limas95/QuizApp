package com.example.daniel.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Quiz> quizzes = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Quiz quiz = new Quiz("My Quiz");
        System.out.println("Name: "+ quiz.getName());
        System.out.println();

        quiz.addQuestion("Am i 21 years old", true, "I was born on Nov 30 1995", 5);
        quiz.addQuestion("Am i from USA", true, "I was born in HP Mission hospital", 4);
        quiz.addQuestion("Is the sky blue", true, "during the day", 1);
        quiz.addQuestion("Are you a human?", true, "are you perfect?", 4);
        quiz.addQuestion("Albert Einstien is mexican?", false, "Re-Read his name", 4);

        Quiz quiz1 = new Quiz("My Quiz 2");
        quiz1.addQuestion("Am i 22 years old", true, "I was born on Nov 30 1996", 5);
        quiz1.addQuestion("Am i from USA", true, "I was born in HP Mission hospital", 4);
        quiz1.addQuestion("Is the sky blue", true, "during the day", 1);
        quiz1.addQuestion("Are you a human?", true, "are you perfect?", 4);
        quiz1.addQuestion("Albert Einstien is mexican?", false, "Re-Read his name", 4);

        Quiz quiz2 = new Quiz("My Quiz 3");
        quiz2.addQuestion("Am i 23 years old", true, "I was born on Nov 30 1997", 5);
        quiz2.addQuestion("Am i from USA", true, "I was born in HP Mission hospital", 4);
        quiz2.addQuestion("Is the sky blue", true, "during the day", 1);
        quiz2.addQuestion("Are you a human?", true, "are you perfect?", 4);
        quiz2.addQuestion("Albert Einstien is mexican?", false, "Re-Read his name", 4);
        quiz2.addQuestion("Am i 23 years old", true, "I was born on Nov 30 1997", 5);
        quiz2.addQuestion("Am i from USA", true, "I was born in HP Mission hospital", 4);
        quiz2.addQuestion("Is the sky blue", true, "during the day", 1);
        quiz2.addQuestion("Are you a human?", true, "are you perfect?", 4);
        quiz2.addQuestion("Albert Einstien is mexican?", false, "Re-Read his name", 4);
        quiz2.addQuestion("Am i 23 years old", true, "I was born on Nov 30 1997", 5);
        quiz2.addQuestion("Am i from USA", true, "I was born in HP Mission hospital", 4);
        quiz2.addQuestion("Is the sky blue", true, "during the day", 1);
        quiz2.addQuestion("Are you a human?", true, "are you perfect?", 4);
        quiz2.addQuestion("Albert Einstien is mexican?", false, "Re-Read his name", 4);


        quizzes.add(quiz);
        quizzes.add(quiz1);
        quizzes.add(quiz2);

        CustomListQuizAdapter quizList = new CustomListQuizAdapter(this, quizzes);

        listView = findViewById(R.id.list_quiz);
        listView.setAdapter(quizList);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DisplayQuestions.class);
                Quiz quiz = quizzes.get(position);
                System.out.println("================="+quiz.getQuestions()+" ==========");
                intent.putParcelableArrayListExtra("questions", quiz.getQuestions());
                startActivity(intent);
            }
        });




    }




}
