package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import ro.ase.eu.aslapplication.intrebariQuiz.Question;

public class GamesActivity extends BaseActivity {

    TextView tvUsor, tvGreu, tvAltQuiz;
    Button btnUsor, btnGreu, btnAltQuiz;
    Spinner spinnerCategory;

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_CATEGORY = "extraCategory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        final Intent intent=getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvUsor=(TextView)findViewById(R.id.tvUsor);
        tvGreu=(TextView)findViewById(R.id.tvGreu);
        tvAltQuiz=(TextView) findViewById(R.id.tvAltQuiz);

        btnUsor=(Button)findViewById(R.id.btnUsor);
        btnGreu=(Button)findViewById(R.id.btnGreu);
        btnAltQuiz=(Button) findViewById(R.id.btnAltQuiz);

        spinnerCategory=(Spinner)findViewById(R.id.spinnerCategory);

        String[] categoryLevels = Question.getAllCategory();

        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categoryLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterDifficulty);

        btnUsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = spinnerCategory.getSelectedItem().toString();

                Intent intent = new Intent(GamesActivity.this, QuizCategoryActivity.class);
                intent.putExtra(EXTRA_CATEGORY, category);
                startActivity(intent);
            }
        });


        btnGreu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGreu=new Intent(GamesActivity.this, QuizAvansatActivity.class);
                intentGreu.putExtra(EXTRA_CATEGORY, "Toate categoriile");
                startActivity(intentGreu);
            }
        });

        btnAltQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuiz=new Intent(GamesActivity.this,QuizExpresiiActivity.class);
                intentQuiz.putExtra(EXTRA_CATEGORY,"Expresii");
                startActivity(intentQuiz);
            }
        });
    }
}
