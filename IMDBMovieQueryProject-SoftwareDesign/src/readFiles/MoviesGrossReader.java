package readFiles;

import movie.Movie;
import movie.MovieDatabase;

/**
 * Reads and processes gross earnings data.
 */
public class MoviesGrossReader extends FileProcessor {

    private static final int GROSS_INDEX = 3;

    public MoviesGrossReader(MovieDatabase movieDatabase) {
        super(movieDatabase);
    }

    @Override
    protected void processLine(String[] columns, Movie movie) {
        try {
            long gross = Long.parseLong(columns[GROSS_INDEX]);
            movie.setGross(gross);
        } catch (NumberFormatException e) {
            movie.setGross(0L);
        }
    }
}
