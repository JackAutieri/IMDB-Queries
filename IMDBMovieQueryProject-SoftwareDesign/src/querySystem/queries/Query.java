/**
 * @author Jack Autieri
 * @description This interface defines the structure for queries that can be executed
 * on a MovieDatabase. Classes implementing this interface must define the execute method.
 */

package querySystem.queries;

import movie.MovieDatabase;

/**
 * The Query interface defines a contract for query classes.
 * Each query must implement the execute method to perform its specific operation
 * on the provided MovieDatabase.
 */
public interface Query {
    /**
     * Executes the query using the provided MovieDatabase instance.
     *
     * @param movieDatabase the movie database to query
     */
    void execute(MovieDatabase movieDatabase);
}
