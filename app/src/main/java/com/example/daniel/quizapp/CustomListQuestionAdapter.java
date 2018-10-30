package com.example.daniel.quizapp;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniel on 10/11/18.
 */

public class CustomListQuestionAdapter extends ArrayAdapter {
    private final Activity context;

    private final ArrayList<Question> questions;

    private final ArrayList<Question> wrong;

    private TextView question;

    public CustomListQuestionAdapter(Activity context, ArrayList<Question> questions, ArrayList<Question> wrong){
        super(context, R.layout.listview_question, questions );
        this.context = context;
        this.questions = questions;
        this.wrong = wrong;
    }

    public View getView(int position, View v, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_question, null,true);
        question = rowView.findViewById(R.id.question);

        if(wrong == null){

            question.setText(this.questions.get(position).toString());

        }else{
            showWrong(position);
        }






        return rowView;
    }

    private void showWrong(int position) {

        question.setText(this.questions.get(position).toString());

        if(this.wrong.contains(this.questions.get(position))){

            question.setBackgroundColor(Color.parseColor("#ff6961"));

        }else{

            question.setBackgroundColor(Color.parseColor("#90EE90"));
        }


    }
}
