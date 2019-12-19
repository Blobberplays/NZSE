package com.example.nzse;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Agency implements Serializable {


    private ArrayList<Client> client_list;
    ArrayList<Immobilie> immobilie_list;


    Agency() {
        client_list = new ArrayList<Client>();
        immobilie_list = new ArrayList<Immobilie>();

        //immobilie_list.add(new Immobilie(100, 1, false, 3, "picture.jpeg"));
    }


    public ArrayList<Client> getClient_list() {
        return client_list;
    }

    public ArrayList<Immobilie> getImmobilie_list() {
        return immobilie_list;
    }

    public void add_into_client_list(Client c) {
        client_list.add(c);
    }

    public void add_into_immobilie_list(Immobilie i) {
        immobilie_list.add(i);
    }


    public Immobilie find_immobillie_by_id(long id) {
        for (Immobilie a : immobilie_list) {
            if (a.getId() == id) {
                return a;

            }
        }
        return null;
    }


    public  void store(Context c) {
        try {
            File myFile = new File(Environment.getExternalStorageDirectory().getPath()
                    + "/" + "Immobilien.txt");
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            JSONArray jsonarray = new JSONArray();
            for(int i= 0; i< immobilie_list.size(); i++) {
                JSONObject object = new JSONObject();
                Immobilie im = immobilie_list.get(i);
                object.put("id", im.getId());
                object.put("preis", im.getPrice());
                object.put("raumzahl", im.getRooms_count());
                object.put("bildquelle", im.getPrice());
                object.put("buy", im.isBuy());
                object.put("smoke", im.isSmoke());
                object.put("animals", im.isAnimals());
                object.put("provision", im.getProvision());
                jsonarray.put(object);
            }
            
            myOutWriter.append(jsonarray.toString());
            myOutWriter.close();
            fOut.close();
            Toast.makeText(c, immobilie_list.size() +" werden gespeichert!",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}


//just a simple comment