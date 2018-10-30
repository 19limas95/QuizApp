package com.example.daniel.quizapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayQuestions extends AppCompatActivity {
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_questions);
        quiz = getIntent().getExtras().getParcelable("Quiz");
        CustomListQuestionAdapter listQuestion  = new CustomListQuestionAdapter(this, quiz.getQuestions(),null);
        ListView list = findViewById(R.id.list_ques);
        list.setAdapter(listQuestion);

    }

    public void startQuiz(View v){

        Intent intent = new Intent(DisplayQuestions.this, QuizActivity.class);
        intent.putExtra("sampleQuiz", quiz);
        startActivity(intent);
    }
}
