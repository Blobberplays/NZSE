package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import java.util.ArrayList;

public class Search extends AppCompatActivity {
    public RecyclerViewAdapter getAdapter() {
        return adapter;
    }

    Agency a;
    SharedPreferences pref;


    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        a = (Agency) getIntent().getSerializableExtra("Agency");
        pref = this.getSharedPreferences("searchPreferences", Context.MODE_PRIVATE);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        //prep Arraylist
        boolean animalAllowed = pref.getBoolean("animalAllowed", false);
        boolean smokeAllowed = pref.getBoolean("smokeAllowed", false);
        boolean buyAllowed = pref.getBoolean("buyAllowed", false);
        boolean marked = pref.getBoolean("marked", false);

        ArrayList<Immobilie> filteredImm = new ArrayList<>();

        if (marked) {
            for (final Immobilie immo : a.getImmobilie_list()) {
                if (marked == immo.isIntrested()) {
                    filteredImm.add(immo);
                }
            }
        } else {

            for (final Immobilie immo : a.getImmobilie_list()) {
                if (animalAllowed == immo.isAnimals() && smokeAllowed == immo.isSmoke() && buyAllowed == immo.isBuy() )





                {
                    filteredImm.add(immo);
                }
            }
        }


        adapter = new RecyclerViewAdapter(filteredImm);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    /*@Override
    protected void onPause() {
        super.onPause();

        Intent intent = new Intent().putExtra(
                "Agency", getIntent().getSerializableExtra("Agency"));

        setResult(RESULT_OK, intent);

        //finish(); böse sehr sehr böse
        //finish()->(Parent)onActivityResult->onDestroy

    }*/

    @Override
    public void onBackPressed() {//back produces RESULT_CANCELED
        //super.onBackPressed();
        Intent intent = new Intent().putExtra(
                "Agency", getIntent().getSerializableExtra("Agency"));

        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        a.store(this);
    }
}



/*Agency local_agency;
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
    }*/
