package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button button_kunde;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_kunde = findViewById(R.id.button_kunde);
        button_kunde.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openScreenCustomer();
            }
        });

        Button button_makler = findViewById(R.id.button_makler);
        button_makler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreenAgent();
            }
        });
    }
        void openScreenCustomer(){
            Intent intend = new Intent(this ,Kunde.class).
                    putExtra("test_string", "das ist ein test String von Intend");

            startActivity(intend);

        }

        void openScreenAgent(){
            Intent intend = new Intent(this ,Makler.class);
            startActivity(intend);
        }
}

