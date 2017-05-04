package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

    public InternalPage(PageManager pages) {
        super(pages);
    }

    public InternalPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.cssSelector(".admin")));
        return this;
    }

    @FindBy(css = ".admin")
    private WebElement adminBar;

    @FindBy(css = "#modal > div > a:nth-child(2)")
    private WebElement userEdit;

    @FindBy(css = "#modal > div > a:nth-child(1)")
    private WebElement logoutLink;

    @FindBy(css = ".closebtn")
    private WebElement closeBar;

    public String getAdminBarUsername() {
        return adminBar.getText();
    }

//    public UserProfilePage clickUserProfilePage() {
//        userProfileLink.click();
//        return pages.userProfilePage;
//    }
//
//    public UserEditPage clickChangePassword() {
//        adminBar.click();
//        userEdit.click();
//        return pages.userEditPage;
//    }

    public LoginPage clickLogoutLink() {
        adminBar.click();
        logoutLink.click();
        wait.until(presenceOfElementLocated(By.id("username")));
        return pages.loginPage;
    }
}
