package readFiles;

import movie.Movie;
import movie.MovieDatabase;

/**
 * Reads and processes top-rated movies data.
 */
public class TopRatedMoviesReader extends FileProcessor {

    private static final int RATING_INDEX = 3;

    public TopRatedMoviesReader(MovieDatabase movieDatabase) {
        super(movieDatabase);
    }

    @Override
    protected void processLine(String[] columns, Movie movie) {
        try {
            double rating = Double.parseDouble(columns[RATING_INDEX]);
            movie.setRating(rating);
        } catch (NumberFormatException e) {
            movie.setRating(0.0);
        }
    }
}
