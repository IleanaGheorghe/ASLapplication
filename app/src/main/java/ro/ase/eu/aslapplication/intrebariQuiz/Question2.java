package ro.ase.eu.aslapplication.intrebariQuiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ileana Gheorghe on 6/11/2018.
 */

public class Question2 implements Parcelable {

    private String question2;
    private String option12;
    private String option22;
    private String option32;
    private String option42;
    private int answerNr2;

    protected Question2(Parcel in) {
        question2 = in.readString();
        option12 = in.readString();
        option22 = in.readString();
        option32 = in.readString();
        option42 = in.readString();
        answerNr2 = in.readInt();
    }

    public static final Creator<Question2> CREATOR = new Creator<Question2>() {
        @Override
        public Question2 createFromParcel(Parcel in) {
            return new Question2(in);
        }

        @Override
        public Question2[] newArray(int size) {
            return new Question2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question2);
        dest.writeString(option12);
        dest.writeString(option22);
        dest.writeString(option32);
        dest.writeString(option42);
        dest.writeInt(answerNr2);
    }

    public Question2() {
    }

    public Question2(String question2, String option12, String option22, String option32, String option42, int answerNr2) {
        this.question2 = question2;
        this.option12 = option12;
        this.option22 = option22;
        this.option32 = option32;
        this.option42 = option42;
        this.answerNr2 = answerNr2;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getOption12() {
        return option12;
    }

    public void setOption12(String option12) {
        this.option12 = option12;
    }

    public String getOption22() {
        return option22;
    }

    public void setOption22(String option22) {
        this.option22 = option22;
    }

    public String getOption32() {
        return option32;
    }

    public void setOption32(String option32) {
        this.option32 = option32;
    }

    public String getOption42() {
        return option42;
    }

    public void setOption42(String option42) {
        this.option42 = option42;
    }

    public int getAnswerNr2() {
        return answerNr2;
    }

    public void setAnswerNr2(int answerNr2) {
        this.answerNr2 = answerNr2;
    }
}
