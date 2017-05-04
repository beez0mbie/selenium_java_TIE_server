package ru.st.selenium.applogic0;

import ru.st.selenium.applogic.NavigationHelper;

public class NavigationHelper0 extends DriverBasedHelper implements NavigationHelper {

  private String baseUrl;

  public NavigationHelper0(ApplicationManager0 manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }
  
  @Override
  public void openMainPage() {
    driver.get(baseUrl);
  }

  @Override
  public void openRelativeUrl(String url) {
    driver.get(baseUrl + url);
  }
  
  @Override
  public void gotoUserProfilePage() {
//    pages.internalPage.ensurePageLoaded().clickUserProfilePage();
    //driver.findElement(By.cssSelector("nav a[href $= '?go=profile']"))
    //  .click();
    // openRelativeUrl("?go=profile");
  }

  @Override
  public void gotoUserManagementPage() {
//    pages.internalPage.ensurePageLoaded().clickUserManagementLink();
    //driver.findElement(By.cssSelector("nav a[href $= '?go=users']"))
    //  .click();
    //openRelativeUrl("?go=users");
  }

}
