package com.example.pokedex.utilities;

public class ConsoleOutputUtility {
    OutputFormat outputFormat;
    PokemonGenerator formatPokemonGenerator;
    PokemonDescriptionGenerator formatDescriptionGenrator ;

    /*
    * To respect the Interface Segregation, I create 2 interfaces :
    *   - one for Pokemon model,
    *   - second for PokemonDescription model
    *
    * This 2 interfaces implements same functions, but one with Description, other with no Description
    *
    *
    * To allow to make the difference between this 2 type, I create 2 constructors and
    * 2 functions (makeOutput, makeOutputDescription) for this 2 differents types
     */

    public ConsoleOutputUtility(OutputFormat outputFormat, PokemonGenerator pokemonGenerator) {
        this.outputFormat = outputFormat;
        this.formatPokemonGenerator = pokemonGenerator;
        makeOutput(formatPokemonGenerator);
    }

    public ConsoleOutputUtility(OutputFormat outputFormat, PokemonDescriptionGenerator formatsDescriptionGenerator) {
        this.outputFormat = outputFormat;
        this.formatDescriptionGenrator = formatsDescriptionGenerator;
        makeOutputDescription(formatDescriptionGenrator);
    }



    public void makeOutput(PokemonGenerator format) {
        if (this.outputFormat == OutputFormat.TEXT) {
            System.out.println(format.generateHumanReadableText());
        } else if (this.outputFormat == OutputFormat.HTML) {
            System.out.println(format.generateHTML());
        } else if (this.outputFormat == OutputFormat.CSV) {
            System.out.println(format.generateCSV());
        }
    }

    public void makeOutputDescription(PokemonDescriptionGenerator format) {
        if (this.outputFormat == OutputFormat.TEXT) {
            System.out.println(format.generateHumanReadableText());
        } else if (this.outputFormat == OutputFormat.HTML) {
            System.out.println(format.generateHTML());
        } else if (this.outputFormat == OutputFormat.CSV) {
            System.out.println(format.generateCSV());
        }
    }
}
