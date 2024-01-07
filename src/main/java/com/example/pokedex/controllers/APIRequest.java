package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class APIRequest implements CreatePokemon {
    private String name ;
    private int id ;
    private int height ;
    private int weight ;

    public APIRequest(JSONObject obj, int id){
        this.id = id ;
        this.name = (String) obj.get("name") ;
        this.weight = ((Long) obj.get("weight")).intValue() ;
        this.height = ((Long) obj.get("height")).intValue();
    }

    public Pokemon run(){
        Pokemon pokemon = new Pokemon(this.id,this.name, this.weight, this.height) ;
        return pokemon ;
    }
}
