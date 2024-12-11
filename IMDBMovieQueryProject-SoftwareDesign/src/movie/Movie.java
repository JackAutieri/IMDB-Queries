/**
 * @author Jack Autieri
 * @description This class represents a movie and encapsulates its details,
 * such as title, year, director, cast, gross earnings, and rating. It provides
 * methods to manage and retrieve movie information.
 */

package movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a movie with its details, including title, year of release,
 * director, cast, gross earnings, and rating.
 */
public class Movie {
    private final String title; // Title of the movie
    private final int year; // Year the movie was released
    private String director; // Director of the movie
    private final List<String> cast; // List of cast members
    private Long gross; // Gross earnings of the movie
    private Double rating; // Rating of the movie

    /**
     * Constructs a Movie object with a title and year of release.
     * 
     * @param title the title of the movie
     * @param year  the year the movie was released
     */
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        this.cast = new ArrayList<>();
    }

    // Getters and setters

    /**
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the year the movie was released
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the director of the movie.
     * 
     * @param director the name of the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * @return the list of cast members in the movie
     */
    public List<String> getCast() {
        return cast;
    }

    /**
     * Adds a cast member to the movie.
     * 
     * @param actor the name of the actor/actress to add to the cast
     */
    public void addCastMember(String actor) {
        this.cast.add(actor);
    }

    /**
     * Sets the gross earnings of the movie.
     * 
     * @param gross the gross earnings of the movie in dollars
     */
    public void setGross(Long gross) {
        this.gross = gross;
    }

    /**
     * @return the gross earnings of the movie
     */
    public Long getGross() {
        return gross;
    }

    /**
     * Sets the rating of the movie.
     * 
     * @param rating the rating of the movie
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * @return the rating of the movie
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @return a string representation of the movie with all its details
     */
    @Override
    public String toString() {
        return "Title: " + title +
                "\nYear: " + year +
                "\nDirector: " + director +
                "\nCast: " + String.join(", ", cast) +
                "\nGross: $" + gross +
                "\nRating: " + rating;
    }
}
