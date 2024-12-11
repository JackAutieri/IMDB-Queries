/**
 * @author Jack Autieri
 * @description This class implements the Query interface to retrieve and display
 * movie details based on a rank. The rank can be sorted by either rating or gross earnings.
 * It interacts with the user to get the type of ranking and the rank itself.
 */

package querySystem.queries;

import movie.MovieDatabase;

import java.util.Scanner;

/**
 * The MovieDetailsQuery class handles user interaction to retrieve
 * and display details of a movie by rank, sorted by either rating or gross earnings.
 */
public class MovieDetailsQuery implements Query {

    /**
     * Executes the query to retrieve and display movie details by rank.
     * Users specify the type of ranking ("rating" or "gross") and the rank.
     *
     * @param movieDatabase the movie database to query
     */
    @Override
    public void execute(MovieDatabase movieDatabase) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the type of ranking (rating or gross)
        System.out.print("Search by (rating/gross): ");
        String type = scanner.nextLine().toLowerCase();

        // Prompt the user to specify the rank
        System.out.print("Enter rank: ");
        int rank = scanner.nextInt();

        // Retrieve movie details for the given type and rank
        String details = movieDatabase.getMovieDetailsByRank(type, rank);

        // Display the retrieved details or an error message if applicable
        System.out.println(details);
    }
}
