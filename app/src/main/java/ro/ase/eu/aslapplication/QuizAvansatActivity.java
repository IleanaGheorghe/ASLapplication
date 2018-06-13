package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import ro.ase.eu.aslapplication.intrebariQuiz.Question2;
import ro.ase.eu.aslapplication.intrebariQuiz.QuizDbHelper;
import ro.ase.eu.aslapplication.intrebariQuiz.WebViewAdapter;

public class QuizAvansatActivity extends BaseActivity {

    public static final String EXTRA_SCORE2 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS2 = 60000;

    private static final String KEY_SCORE2 = "keyScore";
    private static final String KEY_QUESTION_COUNT2 = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT2 = "keyMillisLeft";
    private static final String KEY_ANSWERED2 = "keyAnswered";
    private static final String KEY_QUESTION_LIST2 = "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private TextView textViewCategoryA;
    private GridView gridView;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<Question2> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question2 currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    private String[] url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_avansat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        textViewCategoryA = findViewById(R.id.text_view_categoryA);
        textViewQuestion = findViewById(R.id.text_view_questionA);
        textViewScore = findViewById(R.id.text_view_scoreA);
        textViewQuestionCount = findViewById(R.id.text_view_question_countA);
        textViewCountDown = findViewById(R.id.text_view_countdownA);

        buttonConfirmNext = findViewById(R.id.button_confirm_nextA);
        gridView =findViewById(R.id.gridGif);

        rbGroup = findViewById(R.id.radio_groupA);
        rb1 = findViewById(R.id.radio_button1A);
        rb2 = findViewById(R.id.radio_button2A);
        rb3 = findViewById(R.id.radio_button3A);
        rb4 =findViewById(R.id.radio_button4A);

        Intent intent = getIntent();

        String category = intent.getStringExtra(GamesActivity.EXTRA_CATEGORY);

        textViewCategoryA.setText("Categorie: " + category);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        if(savedInstanceState==null){
            Log.d("este null", "este null");
        }

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList=dbHelper.getQuestionQuizAvansat();
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);

            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST2);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT2);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE2);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT2);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED2);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizAvansatActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion2());
            url=new String[4];
            url[0]=currentQuestion.getOption12();
            url[1]=currentQuestion.getOption22();
            url[2]=currentQuestion.getOption32();
            url[3]=currentQuestion.getOption42();
            WebViewAdapter webViewAdapter=new WebViewAdapter(this,url);
            gridView.setAdapter(webViewAdapter);
            rb1.setText("1");
            rb2.setText("2");
            rb3.setText("3");
            rb4.setText("4");

            questionCounter++;
            textViewQuestionCount.setText("Intrebare: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS2;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr2()) {
            score++;
            textViewScore.setText("Scor: " + score);
        }

        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr2()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Raspunsul 1 ieste corect");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Raspunsul 2 este corect");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Raspunsul 3 este corect");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Raspunsul 4 este corect");
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
            AlertDialog.Builder builder=new AlertDialog.Builder(QuizAvansatActivity.this);

            builder.setTitle("Scor");
            builder.setMessage("Ați obținut : "+score);
            builder.setPositiveButton("OK",null);
            builder.setIcon(R.drawable.ic_alert);
            AlertDialog dialog=builder.create();
            dialog.show();
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE2, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE2, score);
        outState.putInt(KEY_QUESTION_COUNT2, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT2, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED2, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST2, questionList);
    }

}
