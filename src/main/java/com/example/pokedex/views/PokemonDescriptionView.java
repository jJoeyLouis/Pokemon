package com.example.pokedex.views;

import com.example.pokedex.models.PokemonDescription;
import com.example.pokedex.utilities.PokemonDescriptionGenerator;

public class PokemonDescriptionView implements PokemonDescriptionGenerator {

    // These functions use model "PokemonDescription", and so, that why  pokemon.getDescription() is defined
    private PokemonDescription pokemon ;
    public PokemonDescriptionView(PokemonDescription pokemonDescription){
        this.pokemon = pokemonDescription ;
    }

    public String generateHTML(){
        String res = "<h1>" + pokemon.getName() + "</h1> \n <ul> \n" + "<li> Id : " + pokemon.getId() + " </li> \n" + "<li> Taille : " + pokemon.getHeight() + " </li> \n" + " <li> Poids : " + pokemon.getWeight() + " </li> \n" +  " <li> Description : " + pokemon.getDescription() + "</li> \n </ul>";
        return res ;
    }
    public String generateCSV(){
        String res = "Id;Name;Height;Weight;Description \n" + pokemon.getId() + ";" + pokemon.getName() + ";"+ pokemon.getHeight() + ";"+ pokemon.getWeight() + ";"+ pokemon.getDescription() ;
        return res ;
    }
    public String generateHumanReadableText(){
        String res = "############################# \n" + "Pokemon #" + pokemon.getId() + "\n" + "Nom : " + pokemon.getName() + "\n" + "Taille : " + pokemon.getHeight() + "\n" + "Poids : " + pokemon.getWeight() + "\n" +  "Description : " + pokemon.getDescription() + "\n" + "#############################" ;
        return res ;
    }
}
