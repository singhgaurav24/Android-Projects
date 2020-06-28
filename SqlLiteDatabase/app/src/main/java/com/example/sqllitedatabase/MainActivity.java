package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {


    EditText etname,etmob;
    Button btnsubmit,btnshow,btndelet,btnedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etname = findViewById(R.id.etname);
        etmob = findViewById(R.id.etmob);

        btnedit = findViewById(R.id.btnedit);
        btnshow = findViewById(R.id.btnshow);
        btndelet = findViewById(R.id.btndelet);
        btnsubmit = findViewById(R.id.btnsubmit);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString().trim();
                String cell = etmob.getText().toString().trim();

                try {
                    ContactsDb sqLiteDatabase = new ContactsDb(MainActivity.this);
                    sqLiteDatabase.open();
                    sqLiteDatabase.createEntry(name ,cell);
                    sqLiteDatabase.close();
                    Toast.makeText(MainActivity.this,"Successfullu saved",Toast.LENGTH_SHORT).show();
                    etname.setText("");
                    etmob.setText("");
                }
                catch(SQLException e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage()
                    ,Toast.LENGTH_SHORT).show();
                }




            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                 ContactsDb db = new ContactsDb(MainActivity.this);
                 db.open();
                 db.updateEntry("1", " gaurav", "455555555");
                 db.close();
                 Toast.makeText(MainActivity.this,"Sussefully updated",Toast.LENGTH_SHORT).show();
                }
                catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ShowData.class);
                startActivity(i);
            }
        });
        btndelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ContactsDb db = new ContactsDb(MainActivity.this);
                    db.open();
                    db.deletEntry("1");
                    db.close();
                    Toast.makeText(MainActivity.this,"xxx", Toast.LENGTH_SHORT).show();
                }
                catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, "unsusses", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
