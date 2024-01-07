package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescription;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLLiteRequest implements CreatePokemon {

    private String name ;
    private int id ;
    private int height ;
    private int weight ;
    private String description ;

    public SQLLiteRequest(ResultSet rs, int id) throws SQLException {
        this.id = id ;
        this.name = rs.getString("name") ;
        this.weight = rs.getInt("weight") ;
        this.height = rs.getInt("height");
        this.description = rs.getString("description") ;
    }

    public PokemonDescription run()  {
        PokemonDescription pokemonDescription = new PokemonDescription(id, name, weight,height, description) ;
        return pokemonDescription ;
    }
}
