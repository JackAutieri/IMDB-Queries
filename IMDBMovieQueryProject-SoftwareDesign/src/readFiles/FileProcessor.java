package readFiles;

import movie.Movie;
import movie.MovieDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Abstract class for reading and processing files.
 */
public abstract class FileProcessor {
    public static final String TAB_DELIMITER = "\t";
    public static final int MOVIE_TITLE_INDEX = 1;
    public static final int MOVIE_YEAR_INDEX = 2;

    protected final MovieDatabase movieDatabase;

    public FileProcessor(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    /**
     * Abstract method for processing a line of file data.
     */
    protected abstract void processLine(String[] columns, Movie movie);

    /**
     * Reads the file and updates the movie database.
     * Skips the header row automatically.
     */
    public void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }

                String[] columns = splitLine(line);
                if (isValidLine(columns)) {
                    String title = columns[MOVIE_TITLE_INDEX];
                    int year = Integer.parseInt(columns[MOVIE_YEAR_INDEX]);

                    Movie movie = movieDatabase.getMovies().get(title);
                    if (movie == null) {
                        movie = new Movie(title, year);
                        movieDatabase.getMovies().put(title, movie);
                    }

                    processLine(columns, movie);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }

    /**
     * Splits a line of text into columns using the delimiter.
     */
    protected String[] splitLine(String line) {
        return line.split(TAB_DELIMITER);
    }

    /**
     * Validates if the line has enough columns to process.
     */
    protected boolean isValidLine(String[] columns) {
        return columns.length > MOVIE_TITLE_INDEX;
    }

    /**
     * Returns the movie database.
     *
     * @return the MovieDatabase instance
     */
    public MovieDatabase getMovieDatabase() {
        return movieDatabase;
    }
}
