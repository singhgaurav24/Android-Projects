package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity
{


    private Button btnsinout;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnsinout = findViewById(R.id.btnsignout);




        btnsinout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             FirebaseAuth.getInstance().signOut();
                Intent main = new Intent(Account.this , MainActivity.class);
                startActivity(main);
            }
        });


    }


}
