package ru.st.selenium.applogic0;

import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.UserProfilePage;

public class UserHelper0 extends DriverBasedHelper implements UserHelper {

  public UserHelper0(ApplicationManager0 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void loginAs(User user) {
    pages.loginPage.ensurePageLoaded()
      .setUsernameField(user.getLogin())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
  }

  @Override
  public void logout() {
    pages.internalPage.ensurePageLoaded()
      .clickLogoutLink();
  }

  @Override
  public boolean isLoggedIn() {
    return pages.internalPage.waitPageLoaded();
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn()
        && getLoggedUser().getLogin().equals(user.getLogin());
  }

  @Override
  public boolean isNotLoggedIn() {
    return pages.loginPage.waitPageLoaded();
  }
  
  private User getLoggedUser() {
    InternalPage internalPage = pages.internalPage.ensurePageLoaded();
    return new User()
            .setLogin(internalPage.getAdminBarUsername());
  }

}
