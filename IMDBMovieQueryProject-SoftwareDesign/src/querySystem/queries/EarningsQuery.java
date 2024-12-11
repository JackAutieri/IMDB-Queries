/**
 * @author Jack Autieri
 * @description This class implements the Query interface to calculate and display
 * the total box office earnings for movies released in a specific year. It interacts
 * with the user to get the year as input and retrieves data from the MovieDatabase.
 */

package querySystem.queries;

import movie.MovieDatabase;

import java.util.Scanner;

/**
 * The EarningsQuery class handles user interaction to calculate
 * and display the total earnings for movies released in a specified year.
 */
public class EarningsQuery implements Query {

    /**
     * Executes the query to calculate and display total earnings for a user-specified year.
     *
     * @param movieDatabase the movie database to query
     */
    @Override
    public void execute(MovieDatabase movieDatabase) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the year
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // Retrieve total earnings for the specified year
        long earnings = movieDatabase.getTotalEarningsByYear(year);

        // Display the result to the user
        System.out.println("Total earnings for " + year + ": $" + earnings);
    }
}
