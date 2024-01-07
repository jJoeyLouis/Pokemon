package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;

public interface CreatePokemon {
    // Type Pokemon is good, because even if it's "PokemonDescription", "PokemonDescription" is a child of "Pokemon", so everything is OK
    public Pokemon run() ;
}
