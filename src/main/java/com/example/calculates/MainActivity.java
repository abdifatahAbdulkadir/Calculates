package com.example.calculates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
    ImageView bmi, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BMIActivity.class));
                customType(MainActivity.this,"bottom-to-up");
            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AgeActivity.class));
                customType(MainActivity.this,"bottom-to-up");
            }
        });

    }

    public void findViewByIds(){
        bmi = findViewById(R.id.bmi);
        age = findViewById(R.id.age_iv);
    }
}