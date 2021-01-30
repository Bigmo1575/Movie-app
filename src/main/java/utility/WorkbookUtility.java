package utility;

import models.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkbookUtility {

  public static final String INPUT_FILE = "assets\\MovieApplicationxcel.xlsx";

  public static List<Movie> retrieveMovie(final File inputFile) throws IOException, InvalidFormatException {
    final List<Movie> film = new ArrayList<>();

    final Workbook workbook = WorkbookFactory.create(inputFile);
    final Sheet sheet = workbook.getSheetAt(0);

    for(final Row row : sheet) {
      final Cell titleCell = row.getCell(0);
      final Cell directorCell = row.getCell(1);
      final Cell lengthCell = row.getCell(2);

      final Movie movie = new Movie(titleCell.getStringCellValue().trim(), directorCell.getStringCellValue().trim(), (int) lengthCell.getNumericCellValue());

      film.add(movie);
    }


    return film;
  }
}
