/**
 * @author Jack Autieri
 * @description This class handles user interaction, allowing users to query a movie database
 * and execute predefined queries. It serves as the central hub for running and managing queries.
 */

package querySystem;

import movie.MovieDatabase;
import querySystem.queries.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The QuerySystem class facilitates user interaction with a MovieDatabase by
 * providing a menu of query options and executing the corresponding queries.
 */
public class QuerySystem {
    private final MovieDatabase movieDatabase; // Reference to the movie database
    private final Map<String, Query> queries; // Map of query identifiers to Query objects

    /**
     * Constructs a QuerySystem and initializes the available queries.
     *
     * @param movieDatabase the movie database to query
     */
    public QuerySystem(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
        this.queries = new HashMap<>();
        initializeQueries();
    }

    /**
     * Initializes the queries available in the query system and maps them to user options.
     */
    private void initializeQueries() {
        // Add predefined queries to the map with their corresponding keys
        queries.put("E", new EarningsQuery());
        queries.put("D", new DirectorsQuery());
        queries.put("N", new TopDirectorsQuery());
        queries.put("T", new MovieDetailsQuery());
        queries.put("M", new MoviesByDirectorQuery());
    }

    /**
     * Starts the query system, presenting a menu to the user and executing queries based on input.
     * The system runs until the user chooses to quit.
     */
    public void startQuerySystem() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        String choice; // Stores the user's menu choice

        do {
            displayMenu(); // Display the menu options
            choice = scanner.nextLine().toUpperCase(); // Read and normalize user input

            if (queries.containsKey(choice)) {
                // Execute the query corresponding to the user's choice
                queries.get(choice).execute(movieDatabase);
            } else if (!choice.equals("Q")) {
                // Handle invalid input
                System.out.println("Invalid choice, try again.");
            }
        } while (!choice.equals("Q")); // Exit the loop if the user chooses "Q"
    }

    /**
     * Displays the menu of query options to the user.
     */
    private void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("E - Total box office earnings for a given year");
        System.out.println("D - List all directors alphabetically");
        System.out.println("N - List top N directors by number of appearances");
        System.out.println("T - Get movie details by rank (rating/gross)");
        System.out.println("M - Get all movies by a director");
        System.out.println("Q - Quit");
        System.out.print("Enter your choice: ");
    }
}
