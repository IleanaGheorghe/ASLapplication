package ro.ase.eu.aslapplication.intrebariQuiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ileana Gheorghe on 6/10/2018.
 */

public class Question implements Parcelable {

    public static final String CATEGORY_NUMBERE = "Numere";
    public static final String CATEGORY_ALFABET = "Alfabet";
    public static final String CATEGORY_LEGUME = "Legume";
    public static final String CATEGORY_FRUCTE = "Fructe";
    public static final String CATEGORY_ORASE = "Orașe";
    public static final String CATEGORY_LOCURI = "Locuri";
    public static final String CATEGORY_MANCARE = "Mâncare";
    public static final String CATEGORY_BAUTURA = "Băuturi";
    public static final String CATEGORY_FAMILIE = "Familie";
    public static final String CATEGORY_ANIMALE = "Animale";
    public static final String CATEGORY_EMOTII = "Emotii";
    public static final String CATEGORY_EXPRESII="Expresii";


    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    private String urlImage;
    private String category;

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNr = in.readInt();
        urlImage = in.readString();
        category = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNr);
        dest.writeString(urlImage);
        dest.writeString(category);
    }

    public Question(){
    }

    public Question(String question, String option1, String option2, String option3, int answerNr, String urlImage, String category) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.urlImage = urlImage;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllCategory(){
        return new String[]{
                CATEGORY_ALFABET,
                CATEGORY_ANIMALE,
                CATEGORY_BAUTURA,
                CATEGORY_EMOTII,
                CATEGORY_FAMILIE,
                CATEGORY_FRUCTE,
                CATEGORY_LEGUME,
                CATEGORY_LOCURI,
                CATEGORY_MANCARE,
                CATEGORY_NUMBERE,
                CATEGORY_ORASE
        };
    }
}
