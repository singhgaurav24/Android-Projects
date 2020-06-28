package com.example.ranasingh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton imgrana;
    TextView tvname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvname = findViewById(R.id.tvname);
        imgrana = findViewById(R.id.imgrana);

     imgrana.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(MainActivity.this,HomePage.class);
             startActivity(i);

         }
     });



    }
}
