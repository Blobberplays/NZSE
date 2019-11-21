package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Kunde extends AppCompatActivity {
    private TextView display_intend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunde);
        display_intend = (TextView)findViewById(R.id.display_kunde);

        String s= getIntent().getStringExtra("test_string");
        display_intend.setText(s);
    }
}
