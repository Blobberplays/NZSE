package com.example.nzse;

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

    ;

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

    public Immobilie find_immobillie_by_id(long id){
        for(Immobilie a : immobilie_list){
            if(a.getId() == id){
                return a;

            }
        }
    return null;
    };

}

//just a simple comment