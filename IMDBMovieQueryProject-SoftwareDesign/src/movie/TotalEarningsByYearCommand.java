/**
 * @author Jack Autieri
 * @description This class implements the Command interface to calculate and display
 * the total earnings for movies released in a specific year using a MovieDatabase.
 */

package movie;

/**
 * The TotalEarningsByYearCommand class encapsulates the logic for calculating and displaying
 * total movie earnings for a specified year. It implements the Command interface.
 */
public class TotalEarningsByYearCommand implements Command {
    private final MovieDatabase movieDatabase; // Reference to the movie database
    private final int year; // The year for which total earnings will be calculated

    /**
     * Constructs a command to calculate total earnings for a specific year.
     *
     * @param movieDatabase the movie database to query
     * @param year          the year to calculate earnings for
     */
    public TotalEarningsByYearCommand(MovieDatabase movieDatabase, int year) {
        this.movieDatabase = movieDatabase;
        this.year = year;
    }

    /**
     * Executes the command by calculating the total earnings for the specified year
     * and displaying the result.
     */
    @Override
    public void execute() {
        // Calculate total earnings for the given year
        long totalEarnings = movieDatabase.getTotalEarningsByYear(year);

        // Display the result
        System.out.println("Total earnings in " + year + ": $" + totalEarnings);
    }
}
