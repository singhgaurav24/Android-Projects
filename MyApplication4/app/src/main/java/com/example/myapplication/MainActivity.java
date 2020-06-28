package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1=findViewById(R.id.n1);
        EditText et2=findViewById(R.id.n2);
        final int n1=Integer.parseInt(et1.getText().toString());
        final int n2=Integer.parseInt(et2.getText().toString());

        Button b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum=n1+n2;
                TextView t=findViewById(R.id.res);
                t.setText(String.valueOf(sum));
            }
        });

    }
}
