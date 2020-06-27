package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
     EditText ed3;
     Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        ed3 = findViewById(R.id.ed3);
        b3 = findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed3.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"please enter all field",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surname = ed3.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("surname" , surname);
                    setResult(RESULT_OK,intent);
                    Activity3.this.finish();
                }

            }
        });

    }
}
