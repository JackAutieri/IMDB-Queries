/**
 * @author Jack Autieri
 * @description This class implements the Query interface to list all movie directors
 * in alphabetical order. It retrieves the data from the MovieDatabase and displays it.
 */

package querySystem.queries;

import movie.MovieDatabase;

/**
 * The DirectorsQuery class is responsible for listing all directors
 * in the movie database in alphabetical order.
 */
public class DirectorsQuery implements Query {

    /**
     * Executes the query to retrieve and display all directors alphabetically.
     *
     * @param movieDatabase the movie database to query
     */
    @Override
    public void execute(MovieDatabase movieDatabase) {
        // Print a header for the output
        System.out.println("Directors:");
        
        // Retrieve and display all directors in alphabetical order
        movieDatabase.getAllDirectors().forEach(System.out::println);
    }
}
