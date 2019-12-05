package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Kunde extends AppCompatActivity {
    private Button display_search;

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

        startActivity(intend);
    };
}
