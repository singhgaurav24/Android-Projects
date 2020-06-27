package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class register extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4  = findViewById(R.id.et4);
        reg = findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty() || et3.getText().toString().isEmpty()
                           || et4.getText().toString().isEmpty())
                {
                    Toast.makeText(register.this,"please enter all field" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(et3.getText().toString().trim().equals(et4.getText().toString().trim()))
                    {
                        String name =et1.getText().toString().trim();
                        String email = et2.getText().toString().trim();
                        String password = et3.getText().toString().trim();

                        BackendlessUser user = new BackendlessUser();
                        user.setEmail(email);
                        user.getPassword();
                        user.setProperty("name" ,name);




                       Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                           @Override
                           public void handleResponse(BackendlessUser response) {

                           }

                           @Override
                           public void handleFault(BackendlessFault fault) {

                           }
                       })

                    }
                    else
                    {
                        Toast.makeText(register.this,"password and retype passward must be same" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
