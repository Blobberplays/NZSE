package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Kunde extends AppCompatActivity {
    private Button display_search;
    private SeekBar price_SeekBar;
    private TextView seekBarValue;

    final int max = 1000;
    final int min = 1;
    final int avg = (max-min)/2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunde);

        display_search = findViewById(R.id.button_list_immobilien);
        price_SeekBar = findViewById(R.id.simpleSeekBar);
        seekBarValue = findViewById(R.id.display_price);


        display_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openScreenSearch();
            }
        });


        seekbarSet();
    }




    void openScreenSearch() {
        Agency a = (Agency) getIntent().getSerializableExtra("Agency");
        Intent intend = new Intent(this, Search.class).
                putExtra("test_string", "das kommt von Kunde").
                putExtra("Agency", getIntent().getSerializableExtra("Agency"));

        startActivity(intend);
    }
    void seekbarSet(){
        seekBarValue.setText(String.valueOf(min+avg));
        price_SeekBar.setMax(max-min);
        price_SeekBar.setProgress(min+avg);
        price_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(min+progress));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }


}
