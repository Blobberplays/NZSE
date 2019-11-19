package com.example.nzse;
import com.example.nzse.Client;
import com.example.nzse.Immobilie;
import java.util.ArrayList;
public class Agency {

    private ArrayList<Client> client_list = new ArrayList<Client>();
    private ArrayList<Immobilie> immobilie_list = new ArrayList<Immobilie>();

    public ArrayList<Client> getClient_list() {
        return client_list;
    }

    public ArrayList<Immobilie> getImmobilie_list() {
        return immobilie_list;
    }

    public void add_into_client_list(Client c){
        client_list.add(c);
    }
    public void add_into_immobilie_list(Immobilie i){
        immobilie_list.add(i);
    }

}

//just a simple comment