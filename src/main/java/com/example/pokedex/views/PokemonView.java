package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescription;
import com.example.pokedex.utilities.PokemonGenerator;

public class PokemonView implements PokemonGenerator {
    private Pokemon pokemon ;

    public PokemonView(Pokemon pokemon){
        this.pokemon = pokemon ;
    }


    public String generateHTML(){
        String res = "<h1>" + pokemon.getName() + "</h1> \n <ul> \n" + "<li> Id : " + pokemon.getId() + " </li> \n" + "<li> Taille : " + pokemon.getHeight() + " </li> \n" + " <li> Poids : " + pokemon.getWeight() +  "</li> \n </ul>";
        return res ;
    }
    public String generateCSV(){
        String res = "Id;Name;Height;Weight \n" + pokemon.getId() + ";" + pokemon.getName() + ";"+ pokemon.getHeight() + ";"+ pokemon.getWeight()  ;
        return res ;
    }
    public String generateHumanReadableText(){
        String res = "############################# \n" + "Pokemon #" + pokemon.getId() + "\n" + "Nom : " + pokemon.getName() + "\n" + "Taille : " + pokemon.getHeight() + "\n" + "Poids : " + pokemon.getWeight() + "\n"  + "#############################" ;
        return res ;
    }
}
