package com.example.ministoree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private EditText etemil;
    private EditText etpass;
    private Button btnsign;
    private TextView tvsignup;
    ProgressBar progress;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        etemil = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        btnsign = findViewById(R.id.btnsign);
        tvsignup = findViewById(R.id.tvsignup);
        progress = findViewById(R.id.progress);



        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(z);
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null)
                {
                    startActivity(new Intent(MainActivity.this , Page1.class));
                }
            }
        };

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();
                progress.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn()
    {
        String email = etemil.getText().toString();
        String password = etpass.getText().toString();

        if (TextUtils.isEmpty(email)  || TextUtils.isEmpty(password))
        {
            Toast.makeText(MainActivity.this,"Please fill all the field" , Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this, "Sign in Successfully" ,Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }

}

