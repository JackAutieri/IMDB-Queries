/**
 * @author Jack Autieri
 * @description Main entry point for the Movie Database application.
 * This class initializes the movie database by reading data from multiple files
 * and starts the query system to allow user interaction.
 */

import readFiles.*;
import movie.MovieDatabase;
import querySystem.QuerySystem;

public class Main {
    // File paths for the movie data
    private static final String CAST_FILE = "Files/imdb_movies_cast.txt";
    private static final String GROSS_FILE = "Files/imdb_movies_gross.txt";
    private static final String RATINGS_FILE = "Files/imdb_movies_toprated.txt";

    /**
     * Entry point of the application.
     * Initializes the movie database and starts the query system.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Initialize the movie database with data from files
        MovieDatabase movieDatabase = initializeDatabase();

        // Create and start the query system for user interaction
        QuerySystem querySystem = new QuerySystem(movieDatabase);
        querySystem.startQuerySystem();
    }

    /**
     * Initializes the movie database by reading data from the specified files.
     * Each file provides different information about the movies, such as cast, gross earnings, and ratings.
     *
     * @return an instance of MovieDatabase containing all movie data
     */
    private static MovieDatabase initializeDatabase() {
        // Create a reader for movie cast data and read the corresponding file
        MoviesCastReader castReader = new MoviesCastReader();
        castReader.readFile(CAST_FILE);

        // Retrieve the initialized movie database from the cast reader
        MovieDatabase movieDatabase = castReader.getMovieDatabase();

        // Use the existing movie database to populate gross earnings data
        MoviesGrossReader grossReader = new MoviesGrossReader(movieDatabase);
        grossReader.readFile(GROSS_FILE);

        // Use the same movie database to add top-rated movie data
        TopRatedMoviesReader ratingsReader = new TopRatedMoviesReader(movieDatabase);
        ratingsReader.readFile(RATINGS_FILE);

        // Return the fully populated movie database
        return movieDatabase;
    }
}
