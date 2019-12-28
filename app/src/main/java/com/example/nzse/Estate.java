package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Estate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate);


        TextView price = findViewById(R.id.price);
        TextView buyRent = findViewById(R.id.buyrent);
        TextView rooms = findViewById(R.id.rooms);
        ImageView picture = findViewById(R.id.image);
        Immobilie estateIntent = (Immobilie) getIntent().getSerializableExtra("Estate0");

        price.setText(Double.toString(estateIntent.getPrice()));
        buyRent.setText(Boolean.toString(estateIntent.isBuy()));
        rooms.setText(Double.toString(estateIntent.getRooms_count()));


        String pictureName ="p"+estateIntent.getPicture();
        int id = this.getResources().getIdentifier(pictureName, "drawable", this.getPackageName());
        picture.setImageResource(id);
    }
}
