package com.example.exp_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tv1 = findViewById(R.id.tv1);
    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent x = new Intent(MainActivity.this,Go.class);
            startActivity(x);

        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"));
            startActivity(i);
        }
    });
    }

}
