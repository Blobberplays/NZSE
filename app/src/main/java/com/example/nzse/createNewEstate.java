package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class createNewEstate extends AppCompatActivity {

    private EditText price, room, provision, description;
    private CheckBox animal, smoker;
    private Button done;
    private boolean smokeCheck = false;
    private boolean animalCheck = false;
    private boolean buy = false;
    private Agency a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_estate);

        price = findViewById(R.id.price_new);
        room = findViewById(R.id.room_new);
        provision = findViewById(R.id.provision_new);
        description = findViewById(R.id.description_new);
        done = findViewById(R.id.done_button_new);
        Intent myIntent = getIntent();
        a = (Agency) myIntent.getSerializableExtra("Agency");

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (price.getText().toString().isEmpty() || room.getText().toString().isEmpty() || provision.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Preis, Räume oder Provision darf nicht leer sein!",Toast.LENGTH_SHORT ).show();
                }else{

                Immobilie i = new Immobilie(
                        Double.valueOf(price.getText().toString()),
                        Double.valueOf(room.getText().toString()),
                        Double.valueOf(provision.getText().toString()),
                        buy,
                        smokeCheck,
                        animalCheck,
                        description.getText().toString()
                );
                a.add_into_immobilie_list(i);
                Intent intent = new Intent().putExtra(
                        "Agency", a);

                setResult(RESULT_OK, intent);
                finish();
                }

            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_animals_new:
                if (checked)
                    animalCheck = true;
                else
                    animalCheck = false;
                break;
            case R.id.checkbox_smoker_new:
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
            case R.id.radio_rent:
                if (checked)
                    buy = false;
                break;
            case R.id.radio_buy:
                if (checked)
                    buy = true;
                break;
        }
    }
}
