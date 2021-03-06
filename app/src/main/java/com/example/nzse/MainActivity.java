package com.example.nzse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    public static boolean isAgent = false;//maybe declare as interface and implement where needed?
    public static final int saveIntentReq = 1000;

    private Button button_kunde, button_makler;
    Agency myAgency;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initImmoData();
        checkAllPermissions();

        button_kunde = findViewById(R.id.button_kunde);
        button_kunde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAgent = false;
                openScreenCustomer();
            }
        });

        button_makler = findViewById(R.id.button_makler);
        button_makler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO based on isAgent create new widgets!
                isAgent = true;
                openScreenAgent();
            }
        });


    }

    //views
    void openScreenCustomer() {

        intent = new Intent(this, Kunde.class).putExtra("Agency", myAgency);
        startActivityForResult(intent, saveIntentReq);

    }

    void openScreenAgent() {
        intent = new Intent(this, Makler.class).putExtra("Agency", myAgency);
        startActivityForResult(intent, saveIntentReq);

    }

    @Override
    protected void onResume() {
        super.onResume();
        myAgency.store(getApplicationContext());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == saveIntentReq) {
            if (resultCode == RESULT_OK || resultCode == RESULT_CANCELED) {
                getIntent().putExtra("Agency", data.getSerializableExtra("Agency"));
                myAgency = (Agency) data.getSerializableExtra("Agency");

            } else {
                Log.e("Main", "Something went horribly wrong");
            }
        }
    }

    //init
    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{permission},
                    requestCode);
        } else {
            /*Toast.makeText(MainActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();*/
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {

            // Checking whether user granted the permission or not.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Toast.makeText(MainActivity.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public void initImmoData() {
        myAgency = new Agency();
        /*

        myAgency.immobilie_list.add(new Immobilie(99.99, 1, false, 3, true, false,"this is rent"));
        myAgency.immobilie_list.add(new Immobilie(500000, 10, true, 4, true, false,"this is buy"));
        myAgency.immobilie_list.add(new Immobilie(1200.99, 1, false, 3, false, false,"this is rent"));
        myAgency.immobilie_list.add(new Immobilie(900000, 10, true, 4, false, false,"this is buy"));
        myAgency.immobilie_list.add(new Immobilie(400.99, 1, false, 3, true, true,"this is rent"));
        myAgency.immobilie_list.add(new Immobilie(100000, 10, true, 4, true, true,"this is buy"));
        
         */
        myAgency.load(this);
    }

    public void checkAllPermissions() {
        checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
    }

}

