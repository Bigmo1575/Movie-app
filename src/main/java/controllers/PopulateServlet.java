package controllers;

import dao.FilmDaoImpl;
import dao.MovieDao;
import dao.MovieDaoException;
import utility.WorkbookUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PopulateServlet", urlPatterns = "/Populate")
public class PopulateServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);

    final MovieDao movieDao = new FilmDaoImpl();

    String message = "";

    try {
      movieDao.populate(filePath);
      message = "the database was successfully populated";


    } catch (MovieDaoException e) {
      e.printStackTrace();
      message = "the database was NOT successfully populated";
    }

    request.setAttribute("message", message);
  getServletContext().getRequestDispatcher("/populate.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
