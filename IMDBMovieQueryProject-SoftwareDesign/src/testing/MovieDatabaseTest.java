package testing;

import movie.Movie;
import movie.MovieDatabase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MovieDatabaseTest {

    @Test
    public void testGetTotalEarningsByYear() {
        Map<String, Movie> movies = Map.of(
                "Movie1", new Movie("Movie1", 2007),
                "Movie2", new Movie("Movie2", 2007)
        );
        movies.get("Movie1").setGross(1000000L);
        movies.get("Movie2").setGross(2000000L);

        MovieDatabase db = new MovieDatabase(movies);
        assertEquals(3000000L, db.getTotalEarningsByYear(2007));
    }

    @Test
    public void testGetAllDirectors() {
        Map<String, Movie> movies = Map.of(
                "Movie1", new Movie("Movie1", 2000),
                "Movie2", new Movie("Movie2", 2001)
        );
        movies.get("Movie1").setDirector("Director A");
        movies.get("Movie2").setDirector("Director B");

        MovieDatabase db = new MovieDatabase(movies);
        List<String> expected = List.of("Director A", "Director B");
        assertEquals(expected, db.getAllDirectors());
    }

    @Test
    public void testGetMovieDetailsByRank() {
        Map<String, Movie> movies = Map.of(
                "Movie1", new Movie("Movie1", 2000),
                "Movie2", new Movie("Movie2", 2001)
        );
        movies.get("Movie1").setRating(9.0);
        movies.get("Movie2").setRating(8.5);

        MovieDatabase db = new MovieDatabase(movies);
        String details = db.getMovieDetailsByRank("rating", 1);
        assertTrue(details.contains("Movie1"));

        details = db.getMovieDetailsByRank("gross", 1);
        assertEquals("Invalid rank.", details);
    }
}
