package controllers;

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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    try {

      final MovieDao movieDao = new FilmDaoImpl();
      final List<Movie> film = movieDao.retrieveMovie();
      final MovieDao movieDao2 = new FilmDaoImpl();
      final List<Movie> film2 = movieDao2.retrieveMovie();


      String filterString = request.getParameter("title");
      String filterStringDirector = request.getParameter("director");

      final List<Movie> filtered = film.stream().filter((Movie m) -> m.getTitle().equalsIgnoreCase(filterString)).collect(Collectors.toList());
      final List<Movie> filterDirector = film2.stream().filter((Movie m) -> m.getDirector().equalsIgnoreCase(filterStringDirector)).collect(Collectors.toList());
      request.setAttribute("film", filtered);
      request.setAttribute("film2", filterDirector);





    } catch (MovieDaoException e) {
      e.printStackTrace();
    }

    getServletContext().getRequestDispatcher("/view-all.jsp").forward(request,response);


  }
}
