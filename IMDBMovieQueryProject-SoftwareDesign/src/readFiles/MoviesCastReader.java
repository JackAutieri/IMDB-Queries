package readFiles;

import java.util.HashMap;

import movie.Movie;
import movie.MovieDatabase;

/**
 * Reads and processes cast data.
 */
public class MoviesCastReader extends FileProcessor {

    private static final int MOVIE_DIRECTOR_INDEX = 3;
    private static final int MOVIE_CAST_START_INDEX = 4;

    public MoviesCastReader() {
        super(new MovieDatabase(new HashMap<>()));
    }

    @Override
    protected void processLine(String[] columns, Movie movie) {
        movie.setDirector(columns[MOVIE_DIRECTOR_INDEX]);

        for (int i = MOVIE_CAST_START_INDEX; i < columns.length; i++) {
            movie.addCastMember(columns[i]);
        }
    }
}
