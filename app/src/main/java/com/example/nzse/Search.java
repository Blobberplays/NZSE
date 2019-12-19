package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    public RecyclerViewAdapter getAdapter() {
        return adapter;
    }

    RecyclerViewAdapter adapter;
    ArrayList<Immobilie> dataArrayList = new ArrayList<Immobilie>() {
        {
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "examplesfddfdddddfdfdfdfdfdfffffffffffffffffffff description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
            add(new Immobilie(100, 20, true, 4, "haus.jpeg", false, true, "example description"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Agency a = (Agency) getIntent().getSerializableExtra("Agency");
        Intent intend = new Intent(this, RecyclerViewAdapter.class).
                putExtra("Agency", getIntent().getSerializableExtra("Agency"));

        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataArrayList);
        adapter = new RecyclerViewAdapter(a.getImmobilie_list());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


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
