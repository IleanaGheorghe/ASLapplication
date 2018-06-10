package ro.ase.eu.aslapplication.intrebariQuiz;

import android.provider.BaseColumns;

/**
 * Created by Ileana Gheorghe on 6/10/2018.
 */

public final class QuizContract {
    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_ULRIMAGE = "url_imagine";
        public static final String COLUMN_CATEGORY = "category";
    }
}
