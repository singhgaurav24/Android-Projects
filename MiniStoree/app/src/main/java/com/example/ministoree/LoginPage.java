package com.example.ministoree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LoginPage extends AppCompatActivity {
   ImageButton cloth;
   ImageButton medical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

          cloth = findViewById(R.id.cloth);
          medical = findViewById(R.id.medical);
          cloth.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent x = new Intent(getApplicationContext() , Page1.class);
                  startActivity(x);
              }
          });

          medical.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent n = new Intent(getApplicationContext(), Page1.class);
                  startActivity(n);
              }
          });



    }
}
