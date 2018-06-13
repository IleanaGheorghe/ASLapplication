package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ro.ase.eu.aslapplication.activitatiCategorii.AlphabetActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.AnimaleActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.BauturiActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.CuloriActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.EmotiiActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.FamilyActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.FruitsActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.LocuriActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.MancareActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.NumbersActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.OraseActivity;
import ro.ase.eu.aslapplication.activitatiCategorii.VegetablesActivity;

public class LearnActivity1 extends BaseActivity {

    TextView tvAlphabet, tvNumbers, tvColors,tvFruits,tvVegetables,tvFamily, tvEmotii, tvLocuri, tvAnimale, tvOrase, tvMancare, tvBauturi;
    ImageView ivAlphabet, ivNumbers, ivColors,ivFruits,ivVegetables,ivFamily, ivEmotii, ivLocuri, ivAnimale, ivOrase, ivMancare, ivBauturi;
    public static final String EXTRA_CATEGORIE = "Categorie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        final Intent intent=getIntent();

        tvAlphabet=(TextView)findViewById(R.id.tvAlphabet);
        tvNumbers=(TextView)findViewById(R.id.tvNumbers);
        tvColors=(TextView)findViewById(R.id.tvColors);
        tvFruits=(TextView)findViewById(R.id.tvFruits);
        tvVegetables=(TextView)findViewById(R.id.tvVegetables);
        tvFamily=(TextView)findViewById(R.id.tvFamily);
        tvEmotii=(TextView) findViewById(R.id.tvEmotii);
        tvLocuri=(TextView)findViewById(R.id.tvLocuri);
        tvAnimale=(TextView) findViewById(R.id.tvAnimale);
        tvOrase=(TextView)findViewById(R.id.tvOrase);
        tvMancare=(TextView)findViewById(R.id.tvMancare);
        tvBauturi=(TextView)findViewById(R.id.tvBauturi);


        ivAlphabet=(ImageView)findViewById(R.id.ivAlphabet);
        ivNumbers=(ImageView)findViewById(R.id.ivNumbers);
        ivColors=(ImageView)findViewById(R.id.ivColors);
        ivFruits=(ImageView)findViewById(R.id.ivFruits);
        ivVegetables=(ImageView)findViewById(R.id.ivVegetables);
        ivFamily=(ImageView)findViewById(R.id.ivFamily);
        ivEmotii=(ImageView) findViewById(R.id.ivEmotii);
        ivLocuri=(ImageView)findViewById(R.id.ivLocuri);
        ivAnimale=(ImageView) findViewById(R.id.ivAnimale);
        ivOrase=(ImageView)findViewById(R.id.ivOrase);
        ivMancare=(ImageView)findViewById(R.id.ivMancare);
        ivBauturi=(ImageView)findViewById(R.id.ivBauturi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlfabet=new Intent(getApplicationContext(),AlphabetActivity.class);
                startActivity(intentAlfabet);
            }
        });

        tvNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNumere=new Intent(getApplicationContext(),NumbersActivity.class);
                startActivity(intentNumere);
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
                Intent intentLegume=new Intent(getApplicationContext(),VegetablesActivity.class);
                startActivity(intentLegume);
            }
        });
        tvFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamilie=new Intent(getApplicationContext(),FamilyActivity.class);
                startActivity(intentFamilie);
            }
        });

        tvAnimale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAnimale=new Intent(getApplicationContext(), AnimaleActivity.class);
                startActivity(intentAnimale);
            }
        });

        tvMancare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMancare=new Intent(getApplicationContext(), MancareActivity.class);
                startActivity(intentMancare);
            }
        });

        tvBauturi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBauturi=new Intent(getApplicationContext(),BauturiActivity.class);
                startActivity(intentBauturi);
            }
        });
        tvEmotii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmotii=new Intent(getApplicationContext(),EmotiiActivity.class);
                startActivity(intentEmotii);
            }
        });
        tvOrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrase=new Intent(getApplicationContext(),OraseActivity.class);
                startActivity(intentOrase);
            }
        });
        tvLocuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLocuri=new Intent(getApplicationContext(),LocuriActivity.class);
                startActivity(intentLocuri);
            }
        });
        ivAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlfabet=new Intent(getApplicationContext(),AlphabetActivity.class);
                startActivity(intentAlfabet);
            }
        });

        ivNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNumere=new Intent(getApplicationContext(),NumbersActivity.class);
                startActivity(intentNumere);
            }
        });
        ivColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCulori=new Intent(getApplicationContext(),CuloriActivity.class);
                startActivity(intentCulori);
            }
        });
        ivFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFructe=new Intent(getApplicationContext(),FruitsActivity.class);
                startActivity(intentFructe);
            }
        });
        ivVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLegume=new Intent(getApplicationContext(),VegetablesActivity.class);
                startActivity(intentLegume);
            }
        });
        ivFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamilie=new Intent(getApplicationContext(),FamilyActivity.class);
                startActivity(intentFamilie);
            }
        });

        ivAnimale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAnimale=new Intent(getApplicationContext(), AnimaleActivity.class);
                startActivity(intentAnimale);
            }
        });

        ivMancare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMancare=new Intent(getApplicationContext(), MancareActivity.class);
                startActivity(intentMancare);
            }
        });

        ivBauturi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBauturi=new Intent(getApplicationContext(),BauturiActivity.class);
                startActivity(intentBauturi);
            }
        });
        ivEmotii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmotii=new Intent(getApplicationContext(),EmotiiActivity.class);
                startActivity(intentEmotii);
            }
        });
        ivOrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrase=new Intent(getApplicationContext(),OraseActivity.class);
                startActivity(intentOrase);
            }
        });
        ivLocuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLocuri=new Intent(getApplicationContext(),LocuriActivity.class);
                startActivity(intentLocuri);
            }
        });
    }
}
