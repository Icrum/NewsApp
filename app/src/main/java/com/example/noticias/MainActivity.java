package com.example.noticias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonPolitcs;
    Button buttonHealth;
    Button buttonSports;
    Button buttonEntertainment;
    Button buttonScience;
    Button buttonTechnology;
    Button buttonGeneral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonPolitcs=findViewById(R.id.buttonPolitics);
        buttonPolitcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","business");
                Toast.makeText(getBaseContext(), "Business", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonHealth=findViewById(R.id.buttonHealth);
        buttonHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","health");
                Toast.makeText(getBaseContext(), "Health", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonSports=findViewById(R.id.buttonSports);
        buttonSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","sports");
                Toast.makeText(getBaseContext(), "Sports", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonEntertainment=findViewById(R.id.buttonEntertainment);
        buttonEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","entertainment");
                Toast.makeText(getBaseContext(), "Entertainment", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonScience=findViewById(R.id.buttonScience);
        buttonScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","science");
                Toast.makeText(getBaseContext(), "Science", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonTechnology=findViewById(R.id.buttonTechnology);
        buttonTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","technology");
                Toast.makeText(getBaseContext(), "Technology", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        buttonGeneral=findViewById(R.id.buttonGeneral);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("category","general");
                Toast.makeText(getBaseContext(), "General", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
    }
}
