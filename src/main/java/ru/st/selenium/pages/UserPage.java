package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.User;

import java.util.List;

public class UserPage extends InternalPage {

    public UserPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = "a.b-header__link:nth-child(1)")
    private WebElement createNewUser;

    @FindBy(css = "a.b-header__link:nth-child(2)")
    private WebElement listConnectedUsers;

    private By byTableRow = By.className("b-table__row");

    private By byTableCell = By.className("b-table__cell");

    private By byUserForm =  By.className("user_form");

    @FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[1]/div/ul/li/a")
    private WebElement roles;

    private By byRoles = By.xpath("/html/body/div[5]/div/div/div/form/div[1]/div/ul/li/a");

    @FindBy(xpath = "//*[@id=\"dropdown-menu-roles\"]")
    private WebElement dropdownButton;

    @FindBy(css = ".dropdown-menu")
    private WebElement dropdownMenu;

    @FindBy(css = ".button-success")
    private WebElement submitButton;

    @FindBy(css = ".button-cencel")
    private WebElement cencelButton;


    private List<WebElement> roleList;

    private List<WebElement> usersTableCell;

    private List<WebElement> usersTableRow;

    private Select permissionDropdown() {
        return new Select(driver.findElement(By.name("permission")));
    }

    public String getPermission() {
        return permissionDropdown().getFirstSelectedOption().getText();
    }

    private Select rolesDropdown() {
        return new Select(dropdownMenu);
    }

    public void selectRole(User user) {
        rolesDropdown().selectByVisibleText(user.getRole());
    }

    public String getUserLoginFromTable(String getLogin) {
        usersTableCell = driver.findElements(byTableCell);
        for (WebElement cell : usersTableCell) {
            if (cell.getText().trim().equals(getLogin)) {
                return cell.getText();
            }
        }
        System.out.println("Не найден логин в таблице " + getLogin);
        return "!";
    }

    public UserPage clickCreateNewUser() {
        createNewUser.click();
        wait.until(presenceOfElementLocated(byUserForm));
        return this;
    }

    public UserEditPage setCurrentUserRole(String getRole) {
        clickCreateNewUser();
        dropdownButton.click();
        roleList = driver.findElements(byRoles);
        for (WebElement role : roleList) {
            if (role.getAttribute("data-title").trim().equals(getRole)) {
                role.click();
            }
        }
        submitButton.click();
        return pages.userEditPage;
    }
//
//    public String getUsername() {
//        return usernameField.getAttribute("value");
//    }
//
//    public UserPage setUsernameField(String text) {
//        usernameField.sendKeys(text);
//        return this;
//    }
//
//    public String getEmail() {
//        return emailField.getAttribute("value");
//    }
//
//    public UserPage setEmailField(String text) {
//        emailField.sendKeys(text);
//        return this;
//    }
//
//    public UserPage setPassword(String text) {
//        passwordField.sendKeys(text);
//        return this;
//    }
//
//    public UserPage setPassword2(String text) {
//        password2Field.sendKeys(text);
//        return this;
//    }
//
//    public UserPage setRole(String text) {
//        permissionDropdown().selectByVisibleText(text);
//        return this;
//    }


    public UserPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(byTableRow));
        return this;
    }
}
