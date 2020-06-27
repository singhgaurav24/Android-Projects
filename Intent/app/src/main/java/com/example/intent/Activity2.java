package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv2 = findViewById(R.id.tv2);

        String name = getIntent().getStringExtra("name");
        tv2.setText(name +" "+" ,Welcome to activity 2!");

    }
}
