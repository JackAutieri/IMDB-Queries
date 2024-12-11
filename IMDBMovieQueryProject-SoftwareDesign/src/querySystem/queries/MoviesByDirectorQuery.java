/**
 * @author Jack Autieri
 * @description This class implements the Query interface to retrieve and display
 * all movies directed by a specified director. It interacts with the user to get the director's name.
 */

package querySystem.queries;

import movie.Movie;
import movie.MovieDatabase;

import java.util.Scanner;

/**
 * The MoviesByDirectorQuery class handles user interaction to retrieve
 * and display a list of movies directed by a specific director.
 */
public class MoviesByDirectorQuery implements Query {

    /**
     * Executes the query to retrieve and display all movies directed by a user-specified director.
     *
     * @param movieDatabase the movie database to query
     */
    @Override
    public void execute(MovieDatabase movieDatabase) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the director's name
        System.out.print("Enter director name: ");
        String director = scanner.nextLine();

        // Retrieve the list of movies directed by the specified director
        var movies = movieDatabase.getMoviesByDirector(director);

        // Check if movies were found and display results
        if (!movies.isEmpty()) {
            System.out.println("Movies by " + director + ":");
            movies.forEach(movie -> System.out.println(movie.getTitle()));
        } else {
            // Inform the user if no movies were found for the given director
            System.out.println("No movies found for director: " + director);
        }
    }
}
