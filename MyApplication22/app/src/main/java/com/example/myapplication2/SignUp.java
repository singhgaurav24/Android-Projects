package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText emailid,password,cnfpass;
    Button btnsignup;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        cnfpass = findViewById(R.id.cnfpass);
         btnsignup =  findViewById(R.id.btnsignup);

         firebaseAuth = FirebaseAuth.getInstance();
         btnsignup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String email = emailid.getText().toString().trim();
                 String pass =   password.getText().toString().trim();
                 String cnfpassword= cnfpass.getText().toString().trim();

                 if (TextUtils.isEmpty(email))
                 {
                     Toast.makeText(SignUp.this,"Please Enter email" ,Toast.LENGTH_SHORT).show();
                 }
                 if (TextUtils.isEmpty(pass))
                 {
                     Toast.makeText(SignUp.this,"Please Enter password" ,Toast.LENGTH_SHORT).show();
                 }
                 if (TextUtils.isEmpty(cnfpassword))
                 {
                     Toast.makeText(SignUp.this,"Please Enter Conform Password" ,Toast.LENGTH_SHORT).show();
                 }

                 if (password.length()<6)
                 {
                     Toast.makeText(SignUp.this,"Password Length must be grather than 6" ,Toast.LENGTH_SHORT).show();
                 }

                 if (pass.equals(cnfpassword))
                 {
                     firebaseAuth.createUserWithEmailAndPassword(email, pass)

                             .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {




                                     if (task.isSuccessful()) {
                                          startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                         Toast.makeText(SignUp.this,"Registration Successful" ,Toast.LENGTH_SHORT).show();
                                     } else {

                                         Toast.makeText(SignUp.this,"Aurtentication Field" ,Toast.LENGTH_SHORT).show();
                                     }

                                     // ...
                                 }
                             });
                 }



             }
         });



    }
}
