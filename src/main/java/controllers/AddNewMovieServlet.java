package controllers;


import com.google.common.base.Strings;
import dao.FilmDaoImpl;
import dao.MovieDao;
import dao.MovieDaoException;
import models.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewMovieServlet", urlPatterns = "/AddNewMovie")
public class AddNewMovieServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {


      final String title = request.getParameter("title");
      final String director = request.getParameter("director");
      final String lengthInMinutesString = request.getParameter("lengthInMinutes");

      if (Strings.isNullOrEmpty(title) || Strings.isNullOrEmpty(director) || Strings.isNullOrEmpty(lengthInMinutesString)) {
        request.setAttribute("message", "You must complete all fields to submit to the form");

      } else {
        final int lengthInMinutes = Integer.parseInt(lengthInMinutesString);

        final MovieDao movieDao = new FilmDaoImpl();

        final Movie movie = new Movie(title, director, lengthInMinutes);

        movieDao.insertMovie(movie);
        request.setAttribute("message", "THe movie was added");
      }


    } catch (MovieDaoException e) {
      e.printStackTrace();
      request.setAttribute("message", e.getMessage());
    }


    getServletContext().getRequestDispatcher("/add-movie.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    doPost(request, response);
  }
}
