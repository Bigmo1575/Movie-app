package controllers;

import comparator.LengthComparator;
import comparator.TitleComparator;
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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "Viewall", urlPatterns = "/Viewall")
public class Viewall extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String target = "/view-all.jsp";

    try {
      final MovieDao movieDao = new FilmDaoImpl();
      final List<Movie> film = movieDao.retrieveMovie();
      String sortType = request.getParameter("sortType");

      if(null != sortType && sortType.equals("title")) {
        Collections.sort(film, new TitleComparator());
      } else if(null != sortType && sortType.equals("lengthInMinutes")) {
        Collections.sort(film, new LengthComparator());
      }

      request.setAttribute("film", film);

    } catch (MovieDaoException e) {
      e.printStackTrace();
    }

    getServletContext().getRequestDispatcher(target).forward(request,response);
  }
}
