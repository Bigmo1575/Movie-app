package dao;

import models.Movie;

import java.util.List;

public interface MovieDao {

  void populate(String filepath) throws MovieDaoException;

  List<Movie> retrieveMovie() throws MovieDaoException;

  void insertMovie(Movie movie) throws MovieDaoException;
}
