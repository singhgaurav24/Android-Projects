package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowData extends AppCompatActivity {
   TextView tvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvdata = findViewById(R.id.tvdata);

        try {
            ContactsDb db = new ContactsDb(this);
            db.open();
            tvdata.setText(db.getData());
            db.close();
        }
        catch (SQLException e)
        {
            Toast.makeText(ShowData.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
