package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Search extends AppCompatActivity {

    Agency local_agency;
    Immobilie m0,m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        local_agency = (Agency) getIntent().getSerializableExtra("Agency");
        setContentView(R.layout.activity_search);


        Button estate0 = (Button)findViewById(R.id.Estate0);
        Button estate1 = (Button)findViewById(R.id.Estate1);
        m0=local_agency.find_immobillie_by_id(0);
        m1=local_agency.find_immobillie_by_id(1);


        estate0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnEstate(m0);
            }
        });
        estate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnEstate(m1);
            }
        });

    }
    protected  void openAnEstate(Immobilie i){
        Intent EstateOpen = new Intent(this, Estate.class)
                .putExtra("Estate0",m0)
                .putExtra("Estate1",m1);
        startActivity(EstateOpen);
    }
}
