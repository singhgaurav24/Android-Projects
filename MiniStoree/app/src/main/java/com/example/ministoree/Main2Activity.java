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

public class Main2Activity extends AppCompatActivity {
    EditText emailid,password,cnfpass,mobile;
    Button btnsignup;
    ProgressBar progress2;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        cnfpass = findViewById(R.id.cnfpass);
        btnsignup =  findViewById(R.id.btnsignup);
        progress2 = findViewById(R.id.progress2);
        mobile = findViewById(R.id.mobile);
        firebaseAuth = FirebaseAuth.getInstance();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString().trim();
                String pass =   password.getText().toString().trim();
                String cnfpassword= cnfpass.getText().toString().trim();

                 progress2.setVisibility(View.VISIBLE);



                if (TextUtils.isEmpty(email))
                {
                    Toast.makeText(Main2Activity.this,"Please Enter email" ,Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pass))
                {
                    Toast.makeText(Main2Activity.this,"Please Enter password" ,Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(cnfpassword))
                {
                    Toast.makeText(Main2Activity.this,"Please Enter Conform Password" ,Toast.LENGTH_SHORT).show();
                }

                if (password.length()<6)
                {
                    Toast.makeText(Main2Activity.this,"Password Length must be grather than 6" ,Toast.LENGTH_SHORT).show();
                }

                if (pass.equals(cnfpassword))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass)

                            .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {




                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(Main2Activity.this,"Registration Successful" ,Toast.LENGTH_LONG).show();
                                    } else {

                                        Toast.makeText(Main2Activity.this,"Aurtentication Field" ,Toast.LENGTH_LONG).show();
                                    }

                                    // ...
                                }


                            });
                }



            }
        });
    }
}
