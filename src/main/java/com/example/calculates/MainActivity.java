package com.example.calculates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
    private ImageView bmi, age, discount_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.constrainLayout);
        AlphaAnimation animation = new AlphaAnimation(0.0f , 1.0f ) ;
        animation.setFillAfter(true);
        animation.setDuration(1200);
        cl.startAnimation(animation);

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

        discount_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DiscountActivity.class));
                customType(MainActivity.this,"bottom-to-up");
            }
        });

    }

    public void findViewByIds(){
        bmi = findViewById(R.id.bmi);
        age = findViewById(R.id.age_iv);
        discount_iv = findViewById(R.id.discount_iv);
    }
}