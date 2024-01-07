package com.example.pokedex.services;

import java.sql.*;

public class SQLLite {
    // I send the SQL response which contains the data
    public static ResultSet run(int id, String path) {

        /* Connect to the database */
        Connection conn = null;
        ResultSet rs = null ;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + path;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description, weight, height, id FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
            rs    = stmt.executeQuery();
            rs.next();
            return rs ;

            /* PokemonDescription pokemonDescription = SQLLiteRequest.run(rs,id) ;
            new Display(pokemonDescription) ;*/

            //System.out.println("Pokémon name : " + rs.getString("name"));
            // System.out.println("Pokémon description : " + rs.getString("description"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return rs ;
        }

    }
}
