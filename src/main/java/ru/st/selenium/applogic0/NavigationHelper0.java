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
    public void gotoUserEditPage() {
        pages.internalPage.ensurePageLoaded().clickChangePassword();
//    driver.findElement(By.cssSelector("nav a[href $= '?go=profile']"))
//      .click();
//     openRelativeUrl("?go=profile");
    }

    @Override
    public void gotoUserPage() {
        pages.internalPage.ensurePageLoaded().clickUserPage();
        //driver.findElement(By.cssSelector("nav a[href $= '?go=users']"))
        //  .click();
//        openRelativeUrl("?go=users");
    }

}
