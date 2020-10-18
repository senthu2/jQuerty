package com.example.searchuser.service;

import com.example.searchuser.Model.Nyhed;

import java.util.ArrayList;
import java.util.List;

public class Nyheder {
    public List<Nyhed> nyheder = new ArrayList<>();
    public Nyheder() {
        opretDemoNyheder();
    }

    public void tilfoejNyhed(String nyhed){
        nyheder.add(new Nyhed(nyhed));
    }
    private void opretDemoNyheder(){
        Nyhed nyhed = new Nyhed("godt vejr i dag");
        Nyhed nyhed2 = new Nyhed("AJAX rocks!");
        nyheder.add(nyhed);
        nyheder.add(nyhed2);
    }
}