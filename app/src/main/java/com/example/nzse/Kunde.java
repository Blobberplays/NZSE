package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kunde extends AppCompatActivity {
    private Button display_search;
    private SeekBar price_SeekBar;
    private TextView seekBarValue;

    final int max = 1000;
    final int min = 1;
    final int avg = (max-min)/2;

    private Immobilie i;
    private boolean smokeCheck = false;
    private boolean animalCheck = false;
    private boolean buy = false;
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




    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                animalCheck = true;
            else
                animalCheck = false;
                break;
            case R.id.checkbox_cheese:
                if (checked)
                smokeCheck = true;
            else
                smokeCheck = false;
                break;
            // TODO: Veggie sandwich
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    buy = false;
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    buy = true;
                    break;
        }
    }
}
