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

    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li/a[@href='/users']")
    private WebElement users;

    @FindBy(css = "a[href*='/metro']")
    private WebElement metro;

    @FindBy(css = "a[href*='/reports']")
    private WebElement incidents;

    @FindBy(css = "a[href*='/reports']")
    private WebElement reports;

    @FindBy(css = "a[href*='/info']")
    private WebElement info;

    @FindBy(css = "a[href*='/video-wall']")
    private WebElement video_wall;

    @FindBy(css = "a[href*='/insentry-links']")
    private WebElement insentry_links;

    @FindBy(css = "a[href*='/eventlog']")
    private WebElement eventlog;

    @FindBy(css = "a[href*='/audio-archive']")
    private WebElement audio_archive;

    public String getAdminBarUsername() {
        return adminBar.getText();
    }

    public UserPage clickUserPage() {
        users.click();
        return pages.userPage;
    }

    public LoginPage clickLogoutLink() {
        adminBar.click();
        logoutLink.click();
//        wait.until(presenceOfElementLocated(pages.loginPage.byUsernameField));
        return pages.loginPage;
    }

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
