package ru.st.selenium.applogic0;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper0 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper0(ApplicationManager0 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

}
