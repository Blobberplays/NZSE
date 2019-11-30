package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Estate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate);


        TextView price = findViewById(R.id.price);
        TextView buyRent = findViewById(R.id.buyrent);
        TextView rooms = findViewById(R.id.rooms);
        TextView picture = findViewById(R.id.picture);
        Immobilie estateIntent = (Immobilie) getIntent().getSerializableExtra("Estate0");

        price.setText(Double.toString(estateIntent.getPrice()));
        buyRent.setText(Boolean.toString(estateIntent.isBuy()));
        rooms.setText(Double.toString(estateIntent.getRooms_count()));
        picture.setText(estateIntent.getPicture());
    }
}
