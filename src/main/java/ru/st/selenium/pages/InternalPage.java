package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternalPage extends AnyPage {

    public InternalPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = ".admin")
    private WebElement adminBar;

    private By byAdminBar = By.cssSelector(".admin");

    @FindBy(css = "#modal > div > a:nth-child(2)")
    private WebElement userEdit;

    @FindBy(css = "#modal > div > a:nth-child(1)")
    private WebElement logoutLink;

    @FindBy(css = ".closebtn")
    private WebElement closeBar;

    public String getAdminBarUsername() {
        return adminBar.getText();
    }

//    public UserEditPage clickUserProfilePage() {

    public LoginPage clickLogoutLink() {
        adminBar.click();
        logoutLink.click();
        wait.until(presenceOfElementLocated(pages.loginPage.byUsernameField));
        return pages.loginPage;
    }

    //    }
//        return pages.userEditPage;
//        userEdit.click();
//        adminBar.click();

    public UserEditPage clickChangePassword() {
        adminBar.click();
        userEdit.click();
        return pages.userEditPage;
    }

    public InternalPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(byAdminBar));
        return this;
    }
}
