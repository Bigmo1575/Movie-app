package dao;

import models.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.DBUtility;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDaoImpl implements MovieDao{

  final static String DROP_TABLE = "drop table if exists movie;";
  final static String CREATE_TABLE = "create table movie (id integer primary key autoincrement, title text, director text, lengthInMinutes integer);";
  final static String SELECT_ALL_FROM_MOVIE = "select * from movie;";





  @Override
  public void populate(String filepath) throws MovieDaoException{
    Connection connection = null;
    Statement statement = null;

    try {
      connection = DBUtility.createConnection();
      statement = connection.createStatement();

      statement.setQueryTimeout(DBUtility.TIMEOUT);

      statement.executeUpdate(DROP_TABLE);
      statement.executeUpdate(CREATE_TABLE);

      // populate the database from WorkbookUtility

      final File inputFile = new File(filepath);
      final List<Movie> film = WorkbookUtility.retrieveMovie(inputFile);

      for(final Movie movie: film) {
        final String insertValues = "insert into movie (title, director, lengthInMinutes) " +
                                    "values ('" + movie.getTitle() + "', '"
                                    + movie.getDirector() + "', " +
                                      movie.getLengthInMinutes() + ");";

        System.out.println(insertValues);  // NOTES log the sql that we execute

        statement.executeUpdate(insertValues);
      }


    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public List<Movie> retrieveMovie() throws MovieDaoException {

    // create the list of movies
    final List<Movie> film = new ArrayList<>();

    Connection connection = null;
    Statement statement = null;

    try {
      connection = DBUtility.createConnection();
      statement = connection.createStatement();

      statement.setQueryTimeout(DBUtility.TIMEOUT);

      // fetch all from the movie table
      final ResultSet resultset = statement.executeQuery(SELECT_ALL_FROM_MOVIE);

      while(resultset.next()){

        final String title = resultset.getString("title");
        final String director = resultset.getString("director");
        final int lengthInMinutes = resultset.getInt("lengthInMinutes");

        film.add(new Movie(title, director, lengthInMinutes));
      }


    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


    return film;
  }

  @Override
  public void insertMovie(Movie movie) throws MovieDaoException {

    // set up db connection statements
    Connection connection = null;
    PreparedStatement insertStatement = null;

    try {
      connection = DBUtility.createConnection();

      final String sqlString = "insert into movie (title, director, lengthInMinutes) values (?, ?, ?);";

      insertStatement = connection.prepareStatement(sqlString);
      insertStatement.setString(1, movie.getTitle());
      insertStatement.setString(2, movie.getDirector());
      insertStatement.setInt(3, movie.getLengthInMinutes());

      insertStatement.setQueryTimeout(DBUtility.TIMEOUT);

      insertStatement.executeUpdate();

  } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      throw new MovieDaoException("Error unable to insert Movie.");
    }


  }
}
