package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et1 = findViewById(R.id.et1);
       et2 = findViewById(R.id.et2);
       b1 = findViewById(R.id.b1);
       t1 = findViewById(R.id.t1);



       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            int n1 = Integer.parseInt(et1.getText().toString());
               int n2 = Integer.parseInt(et2.getText().toString());
               int sum  = n1+n2;
               t1.setText(String.valueOf(sum));
           }
       });
    }

}
