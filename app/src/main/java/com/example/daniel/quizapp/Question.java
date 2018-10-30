package com.example.daniel.quizapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniel on 10/10/18.
 */

public class Question implements Parcelable{

    private long id;
    private String question;
    private boolean answer;
    private String hint;
    private int point;

    Question(){}

    public Question(String question, boolean answer, String hint, int point){
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.setPoint(point);
    }

    public Question(Parcel parcel){
        this.id = parcel.readLong();
        this.question = parcel.readString();
        this.answer = (parcel.readInt() == 0) ? false :true;
        this.hint = parcel.readString();
        this.point = parcel.readInt();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString() {
        String question = "Question: "+this.question
                +"\nPoint: "+ this.point;
        return question;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.question);
        dest.writeInt(this.answer ? 1 : 0);
        dest.writeString(this.hint);
        dest.writeInt(this.point);

    }

    public static Creator<Question> CREATOR = new Creator<Question>() {

        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }

    };
}