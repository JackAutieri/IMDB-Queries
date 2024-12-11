/**
 * @author Jack Autieri
 * @description This class represents a database of movies and provides methods
 * to query and analyze data, such as total earnings by year, top directors, and
 * movie details by rank.
 */

package movie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The MovieDatabase class stores a collection of movies and provides methods for
 * retrieving and analyzing movie data.
 */
public class MovieDatabase {
    private final Map<String, Movie> movies; // A map of movie titles to their corresponding Movie objects

    /**
     * Constructs a MovieDatabase with the provided map of movies.
     *
     * @param movies a map of movie titles to Movie objects
     */
    public MovieDatabase(Map<String, Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return the map of all movies in the database
     */
    public Map<String, Movie> getMovies() {
        return movies;
    }

    /**
     * Calculates the total gross earnings of movies released in a specific year.
     *
     * @param year the year to filter movies by
     * @return the total gross earnings of movies released in the specified year
     */
    public long getTotalEarningsByYear(int year) {
        return movies.values().stream()
                .filter(movie -> movie.getYear() == year && movie.getGross() != null)
                .mapToLong(Movie::getGross)
                .sum();
    }

    /**
     * Retrieves a list of all directors in the database, sorted alphabetically and without duplicates.
     *
     * @return a list of unique director names
     */
    public List<String> getAllDirectors() {
        return movies.values().stream()
                .map(Movie::getDirector)
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Retrieves the top N directors based on the number of movies they directed.
     *
     * @param n the number of top directors to retrieve
     * @return a list of entries where each entry contains a director's name and their movie count
     */
    public List<Map.Entry<String, Integer>> getTopDirectors(int n) {
        Map<String, Long> directorCounts = movies.values().stream()
                .filter(movie -> movie.getDirector() != null)
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));

        return directorCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(e -> Map.entry(e.getKey(), e.getValue().intValue()))
                .toList();
    }

    /**
     * Retrieves the details of a movie ranked by either rating or gross earnings.
     *
     * @param type the type of ranking ("rating" or "gross")
     * @param rank the rank of the movie to retrieve
     * @return a string representation of the movie details or an error message if inputs are invalid
     */
    public String getMovieDetailsByRank(String type, int rank) {
        List<Movie> sortedMovies;

        if (type.equalsIgnoreCase("rating")) {
            // Sort movies by rating in descending order
            sortedMovies = movies.values().stream()
                    .filter(movie -> movie.getRating() != null)
                    .sorted(Comparator.comparing(Movie::getRating).reversed())
                    .toList();
        } else if (type.equalsIgnoreCase("gross")) {
            // Sort movies by gross earnings in descending order
            sortedMovies = movies.values().stream()
                    .filter(movie -> movie.getGross() != null)
                    .sorted(Comparator.comparing(Movie::getGross).reversed())
                    .toList();
        } else {
            return "Invalid type. Choose 'rating' or 'gross'.";
        }

        // Validate rank input
        if (rank <= 0 || rank > sortedMovies.size()) {
            return "Invalid rank.";
        }

        // Retrieve and return the movie details at the specified rank
        Movie movie = sortedMovies.get(rank - 1);
        return movie.toString();
    }

    /**
     * Retrieves all movies directed by a specific director.
     *
     * @param director the name of the director
     * @return a list of movies directed by the specified director
     */
    public List<Movie> getMoviesByDirector(String director) {
        return movies.values().stream()
                .filter(movie -> director.equals(movie.getDirector()))
                .toList();
    }
}
