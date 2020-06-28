package com.example.sharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView wlc;
   EditText ed1;
   Button b1;

   public static final String My_pref = "com.example.sharedprefences.names";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wlc = findViewById(R.id.wlc);
        ed1 = findViewById(R.id.ed1);
        b1 = findViewById(R.id.b1);


        SharedPreferences prefs = getSharedPreferences(My_pref,MODE_PRIVATE);
        String user = prefs.getString("user", "");
        wlc.setText("Welcome to my page"+" " + user +"!");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed1.getText().toString().trim();
                wlc.setText("Welcome to my page"+" " + name +"!");

                SharedPreferences.Editor editor = getSharedPreferences(My_pref,MODE_PRIVATE).edit();
                editor.putString("user",name);
                editor.commit();

            }


        });
    }
}
