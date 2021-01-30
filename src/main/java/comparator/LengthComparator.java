package comparator;

import models.Movie;

import java.util.Comparator;
public class LengthComparator implements Comparator<Movie> {
  @Override
  public int compare(Movie movies1, Movie movies2) {


    return movies1.getLengthInMinutes().compareTo(movies2.getLengthInMinutes());
  }
}
