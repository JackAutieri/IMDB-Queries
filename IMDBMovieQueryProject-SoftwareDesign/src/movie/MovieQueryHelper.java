/**
 * @author Jack Autieri
 * @description This utility class provides helper methods for querying movie data.
 * It includes methods to retrieve movies by rank, find the closest movie by gross earnings,
 * and list movies by a specific director.
 */

package movie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The MovieQueryHelper class provides static methods for querying movie-related data.
 * It operates on a map structure containing movie details.
 */
public class MovieQueryHelper {

    /**
     * Retrieves the movie details for the movie ranked at the specified position.
     *
     * @param data a map where the key is the movie title, and the value is another map containing movie details
     * @param rank the rank of the movie to retrieve (1-based index)
     * @return a map of movie details for the specified rank, or null if the rank is invalid
     */
    public static Map<String, Object> getMovieByRank(Map<String, Map<String, Object>> data, int rank) {
        // Skip elements up to the specified rank and retrieve the first remaining element
        return data.values().stream()
                .skip(rank - 1)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the movie with gross earnings closest to the specified amount.
     *
     * @param grossData a map where the key is the movie title, and the value is another map containing movie details
     * @param gross the target gross earnings to compare against
     * @return a map of movie details for the closest gross, or null if the data is empty
     */
    public static Map<String, Object> getClosestMovieByGross(Map<String, Map<String, Object>> grossData, long gross) {
        // Find the movie with the smallest absolute difference in gross earnings
        return grossData.values().stream()
                .min(Comparator.comparingLong(details -> Math.abs((long) details.get("Gross") - gross)))
                .orElse(null);
    }

    /**
     * Retrieves a list of movie titles directed by the specified director.
     *
     * @param castData a map where the key is the movie title, and the value is another map containing movie details
     * @param director the name of the director to filter movies by
     * @return a list of movie titles directed by the specified director
     */
    public static List<String> getMoviesByDirector(Map<String, Map<String, Object>> castData, String director) {
        // Filter the movies by director and collect their titles into a list
        return castData.entrySet().stream()
                .filter(entry -> director.equals(entry.getValue().get("Director")))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
