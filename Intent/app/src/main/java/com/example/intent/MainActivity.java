package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button b1,b2;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        ed1 = findViewById(R.id.ed1);
       // final int ACTIVITY3 = 3;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ed1.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "pl enter all field", Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = ed1.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this, com.example.intent.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,com.example.intent.Activity3.class);
                startActivityForResult(intent, 3);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 3)
        {
            if (resultCode == RESULT_OK)
            {
                tv1.setText(data.getStringExtra("surname"));
            }
            if(resultCode== RESULT_CANCELED)
            {
                tv1.setText("no data recivied");
          
            }
        }
    }
}
