package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LearnActivity1 extends BaseActivity {

    TextView tvAlphabet, tvNumbers, tvColors,tvFruits,tvVegetables,tvFamily;
    ImageView ivAlphabet, ivNumbers, ivColors,ivFruits,ivVegetables,ivFamily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        Intent intent=getIntent();

        tvAlphabet=(TextView)findViewById(R.id.tvAlphabet);
        tvNumbers=(TextView)findViewById(R.id.tvNumbers);
        tvColors=(TextView)findViewById(R.id.tvColors);
        tvFruits=(TextView)findViewById(R.id.tvFruits);
        tvVegetables=(TextView)findViewById(R.id.tvVegetables);
        tvFamily=(TextView)findViewById(R.id.tvFamily) ;

        ivAlphabet=(ImageView)findViewById(R.id.ivAlphabet);
        ivNumbers=(ImageView)findViewById(R.id.ivNumbers);
        ivColors=(ImageView)findViewById(R.id.ivColors);
        ivFruits=(ImageView)findViewById(R.id.ivFruits);
        ivVegetables=(ImageView)findViewById(R.id.ivVegetables);
        ivFamily=(ImageView)findViewById(R.id.ivFamily);

        tvAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlphabet=new Intent(getApplicationContext(),AlphabetActivity.class);
                startActivity(intentAlphabet);
            }
        });

        tvNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNumber=new Intent(getApplicationContext(),NumbersActivity.class);
                startActivity(intentNumber);
            }
        });
        tvColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCulori=new Intent(getApplicationContext(),CuloriActivity.class);
                startActivity(intentCulori);
            }
        });
        tvFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFructe=new Intent(getApplicationContext(),FruitsActivity.class);
                startActivity(intentFructe);
            }
        });
        tvVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVegetables=new Intent(getApplicationContext(),VegetablesActivity.class);
                startActivity(intentVegetables);
            }
        });
        tvFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamily=new Intent(getApplicationContext(),FamilyActivity.class);
                startActivity(intentFamily);
            }
        });
    }
}
