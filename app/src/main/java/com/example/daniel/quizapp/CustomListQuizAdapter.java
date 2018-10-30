package com.example.daniel.quizapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniel on 10/11/18.
 */

public class CustomListQuizAdapter extends ArrayAdapter {

    private final Activity context;
    private final ArrayList<Quiz> quizzes;

    public CustomListQuizAdapter(Activity context, ArrayList<Quiz> quizzes){

        super(context, R.layout.listview_quiz , quizzes);

        this.context=context;
        this.quizzes=quizzes;


    }

    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_quiz, null,true);
        TextView txtView = rowView.findViewById(R.id.quiz);
        txtView.setText(quizzes.get(position).getName());

        return rowView;

    }

}
