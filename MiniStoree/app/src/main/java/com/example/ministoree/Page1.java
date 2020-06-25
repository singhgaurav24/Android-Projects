package com.example.ministoree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Page1 extends AppCompatActivity {

    Button btnsignout1;
    ImageButton mobile,cloth,book,cemra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        mobile = findViewById(R.id.mobile);
        cloth = findViewById(R.id.cloth);
        book = findViewById(R.id.book);
        cemra = findViewById(R.id.cemra);
        btnsignout1 = findViewById(R.id.btnsignout1);

        btnsignout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent signout = new Intent(Page1.this,MainActivity.class);
                startActivity(signout);
                Toast.makeText(getApplicationContext(),"Sign-Out Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Page1.this,Nevigate.class);
                startActivity(i);

            }
        });
        cemra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Page1.this,Nevigate.class);
                startActivity(i);

            }
        });

        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Page1.this,Nevigate.class);
                startActivity(i);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Page1.this,Nevigate.class);
                startActivity(i);
            }
        });
    }
}
