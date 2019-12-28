package com.example.nzse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Kunde extends AppCompatActivity {
    private Button display_search, buttonSaved, reset;
    private SeekBar price_SeekBar;
    private TextView seekBarValue;
    private Spinner sortBySpinner;
    private RadioButton buyRadioButton, rentRadioButton;
    private CheckBox animal, smoker;
    private RadioGroup radioButtonGroup;

    static final int reqCode = 100;
    static final int returnCode = 0;

    final int max = 1000;
    final int min = 1;
    final int avg = (max - min) / 2;

    private Immobilie i;
    private boolean smokeCheck = false;
    private boolean animalCheck = false;
    private boolean buy = false;


    Agency a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunde);

        display_search = findViewById(R.id.button_list_immobilien);
        price_SeekBar = findViewById(R.id.simpleSeekBar);
        seekBarValue = findViewById(R.id.display_price);
        buttonSaved = findViewById(R.id.button_list_saved);
        sortBySpinner = findViewById(R.id.spinner_sort);
        reset = findViewById(R.id.button_reset);
        radioButtonGroup = findViewById(R.id.radiobuttons);





        animal = findViewById(R.id.checkbox_meat);
        smoker = findViewById(R.id.checkbox_cheese);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalCheck = false;
                smokeCheck = false;
                seekBarValue.setText(String.valueOf(avg + 1));
                price_SeekBar.setProgress(avg);



                animal.setChecked(false);
                smoker.setChecked(false);

                radioButtonGroup.check(R.id.radio_pirates);



            }
        });

        buttonSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarked();
            }
        });

        display_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openScreenSearch();
            }
        });
        seekbarSet();
    }

    void openMarked() {
        a = (Agency) getIntent().getSerializableExtra("Agency");
        Intent intent = new Intent(this, Search.class).
                putExtra("Agency", getIntent().getSerializableExtra("Agency"));


        SharedPreferences pref = getSharedPreferences("searchPreferences", Context.MODE_PRIVATE);
        pref.edit().putBoolean("marked", true).apply();
        pref.edit().apply();

        startActivityForResult(intent, reqCode);
    }

    void openScreenSearch() {
        a = (Agency) getIntent().getSerializableExtra("Agency");
        Intent intent = new Intent(this, Search.class).
                putExtra("test_string", "das kommt von Kunde").
                putExtra("Agency", getIntent().getSerializableExtra("Agency"));
        //intent.putExtra("Agency", getIntent().getSerializableExtra("Agency"));


        SharedPreferences pref = this.getSharedPreferences("searchPreferences", Context.MODE_PRIVATE);
        pref.edit().putBoolean("animalAllowed", animalCheck).apply();
        pref.edit().putBoolean("smokeAllowed", smokeCheck).apply();
        pref.edit().putBoolean("buyAllowed", buy).apply();

        pref.edit().putInt("maxPrice", Integer.valueOf(seekBarValue.getText().toString())).apply();
        pref.edit().putString("sortedBy", sortBySpinner.getPrompt().toString()).apply();

        pref.edit().putBoolean("marked", false).apply();


        //startActivity(intend);
        startActivityForResult(intent, reqCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqCode) {
            if (resultCode == RESULT_OK) {
                getIntent().putExtra("Agency", data.getSerializableExtra("Agency"));
                a = (Agency) data.getSerializableExtra("Agency");
                // OR
                // String returnedResult = data.getDataString();

            } else if (resultCode == RESULT_CANCELED) {

            } else {
                Log.e("Kunde", "Result from Search is bad...");
            }
        }
    }


    void seekbarSet() {
        seekBarValue.setText(String.valueOf(min + avg));
        price_SeekBar.setMax(max - min);
        price_SeekBar.setProgress(min + avg);
        price_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(min + progress));
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
        switch (view.getId()) {
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
        switch (view.getId()) {
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
