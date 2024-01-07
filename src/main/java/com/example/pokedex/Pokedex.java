package com.example.pokedex;


import com.example.pokedex.controllers.APIRequest;
import com.example.pokedex.controllers.SQLLiteRequest;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescription;
import com.example.pokedex.services.HTTPRequest;
import com.example.pokedex.services.SQLLite;
import com.example.pokedex.utilities.ConsoleOutputUtility;
import com.example.pokedex.utilities.OutputFormat;
import com.example.pokedex.views.PokemonDescriptionView;
import com.example.pokedex.views.PokemonView;
import org.apache.commons.cli.*;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pokedex {

    private enum DataSource {WEB_API, LOCAL_DATABASE}

    private static DataSource dataSource = DataSource.WEB_API;
    private static String databasePath;
    private static OutputFormat outputFormat = OutputFormat.TEXT;
    private static int pokemonId;

    public static void main(String[] args) throws ParseException, SQLException {

        /* Parse the command line arguments, this is done for you, keep this code block */
        try {
            parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }


        //  ################# Add by myself ###############

        /* With the condition "if", I check if my Pokemon has a description or not */
        if(dataSource == DataSource.WEB_API){
            /* No Description, so, the format is :
            * Service : JSONObject
            * Model : Pokemon
            * View : PokemonView (who implements PokemonGenerator, defined in utilities)
            * ConsoleOutputUtility reacts a different way if there is an interface PokemonGenerator or PokemonDescriptionGenerator
            * */

            JSONObject data = HTTPRequest.run(pokemonId) ;
            Pokemon pokemon = new APIRequest(data,pokemonId).run() ;
            PokemonView pokemonView = new PokemonView(pokemon) ;
            ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, pokemonView);

        } else {
            /* With Description :
            * Service : ResultSet, for SQLLite,
            * Model : PokemonDescription
            * View : PokemonDescriptionView (who implements PokemonDescriptionGenerator, defined in utilities)
             */
            ResultSet rs = SQLLite.run(pokemonId,databasePath);
            PokemonDescription pokemonDescription = new SQLLiteRequest(rs,pokemonId).run() ;
            PokemonDescriptionView pokemonDescriptionView = new PokemonDescriptionView(pokemonDescription) ;
            ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, pokemonDescriptionView);
        }

        // ###############################################

    }



    public static void parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("d", "database", true, "Path to a SQLite database containing pokemons");
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");

        // parse the command line arguments
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("d")) {
            dataSource = DataSource.LOCAL_DATABASE;
            databasePath = line.getOptionValue("d");
        }

        if (line.hasOption("f")) {
            String formatArgValue = line.getOptionValue("f");
            if (formatArgValue.equals("html")) {
                outputFormat = OutputFormat.HTML;
            } else if (formatArgValue.equals("csv")) {
                outputFormat = OutputFormat.CSV;
            } else if (formatArgValue.equals("text")) {
                outputFormat = OutputFormat.TEXT;
            } else {
                throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }
        }

        // Get pokemon ID from remaining arguments
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a pokemon ID", options);
        }
        try {
            pokemonId = Integer.parseInt(remainingArgs[0]);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid pokemon ID", options);
        }
    }


    static class PokemonCommandLineParsingException extends Exception {

        private Options options;

        public PokemonCommandLineParsingException(String msg, Options options) {
            super(msg);
            this.options = options;
        }

        public Options getOptions() {
            return options;
        }

    };
}
