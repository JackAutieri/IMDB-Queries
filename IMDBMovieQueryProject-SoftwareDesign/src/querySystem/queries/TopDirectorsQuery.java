/**
 * @author Jack Autieri
 * @description This class implements the Query interface to list the top N directors
 * based on the number of movies they directed. It interacts with the user to specify the number of directors.
 */

package querySystem.queries;

import movie.MovieDatabase;

import java.util.Scanner;

/**
 * The TopDirectorsQuery class handles user interaction to retrieve and display
 * the top N directors based on the number of movies they have directed.
 */
public class TopDirectorsQuery implements Query {

    /**
     * Executes the query to list the top N directors by the number of movies directed.
     * The user specifies the value of N.
     *
     * @param movieDatabase the movie database to query
     */
    @Override
    public void execute(MovieDatabase movieDatabase) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to specify the number of top directors to display
        System.out.print("Enter number of top directors: ");
        int n = scanner.nextInt();

        // Display the top N directors and their movie counts
        System.out.println("Top " + n + " Directors:");
        movieDatabase.getTopDirectors(n).forEach(entry ->
                System.out.println(entry.getKey() + " - " + entry.getValue() + " movies"));
    }
}
