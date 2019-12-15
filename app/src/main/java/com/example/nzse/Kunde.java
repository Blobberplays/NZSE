package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class Kunde extends AppCompatActivity {
    private Button display_search;
    private Immobilie i;
    private boolean smokeCheck = false;
    private boolean animalCheck = false;
    private boolean buy = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunde);

        display_search = (Button)findViewById(R.id.button_list_immobilien);

        display_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openScreenSearch();
            }
        });


    }
    void openScreenSearch(){
        Agency a =(Agency)getIntent().getSerializableExtra("Agency");
        Intent intend = new Intent(this, Search.class).
                putExtra("test_string", "das kommt von Kunde").
                putExtra("Agency",getIntent().getSerializableExtra("Agency"));
                intend.putExtra("anmialCheck", animalCheck);
                intend.putExtra("smokeCheck", smokeCheck);
                intend.putExtra("buyCheck", buy);

        startActivity(intend);
    };

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
