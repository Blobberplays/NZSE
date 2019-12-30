package com.example.nzse;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
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


    public void store(Context c) {
        try {
            File myFile = new File(Environment.getExternalStorageDirectory().getPath()
                    + "/" + "Immobilien.txt");
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            JSONArray jsonarray = new JSONArray();
            for (int i = 0; i < immobilie_list.size(); i++) {
                JSONObject object = new JSONObject();
                Immobilie im = immobilie_list.get(i);
                object.put("id", im.getId());
                object.put("preis", im.getPrice());
                object.put("raumzahl", im.getRooms_count());
                object.put("bildquelle", im.getPicture());
                object.put("buy", im.isBuy());
                object.put("smoke", im.isSmoke());
                object.put("animals", im.isAnimals());
                object.put("provision", im.getProvision());
                object.put("description", im.getDescription());
                object.put("Intrested", im.isIntrested());
                jsonarray.put(object);
            }

            myOutWriter.append(jsonarray.toString());
            myOutWriter.close();
            fOut.close();

            Toast.makeText(c, immobilie_list.size() + " werden gespeichert!",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void load(Context c) {
        String alleausgaben = "";
        try {
            File myFile =
                    new File(Environment.getExternalStorageDirectory().getPath() +
                            "/" + "Immobilien.txt");
            System.out.println("*** Load:" + myFile.toString());

            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn, StandardCharsets.UTF_8.name()));
            String line;
            while ((line = myReader.readLine()) != null) {
                alleausgaben += line;
            }
            JSONArray jsonArray = new JSONArray(alleausgaben);
            Toast.makeText(c, "Anzahl Adressen: " + jsonArray.length(),
                    Toast.LENGTH_SHORT).show();

            Immobilie a;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                a = new Immobilie(
                        jsonObject.getDouble("preis"),
                        jsonObject.getDouble("raumzahl"),
                        jsonObject.getBoolean("buy"),
                        jsonObject.getDouble("provision"),
                        jsonObject.getString("bildquelle"),
                        jsonObject.getBoolean("smoke"),
                        jsonObject.getBoolean("animals"),
                        jsonObject.getString("description"),
                        jsonObject.getBoolean("Intrested"));
                add_into_immobilie_list(a);
            }

            Toast.makeText(c, immobilie_list.size() + " werden geladen!",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}


//just a simple comment