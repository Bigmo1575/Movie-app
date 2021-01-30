package comparator;

import models.Movie;

import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {

  @Override
  public int compare(Movie movie1, Movie movie2) {
    return movie1.getTitle().compareTo(movie1.getTitle());
  }
}
