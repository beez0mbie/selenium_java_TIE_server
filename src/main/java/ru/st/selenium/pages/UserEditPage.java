package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserEditPage extends InternalPage {

    public UserEditPage(PageManager pages) {
        super(pages);
    }

    @FindBy(className = "user_form")
    private WebElement userForm;

    private By byUserForm = By.className("user_form");

    @FindBy(id = "login")
    private WebElement loginField;

    private By byLoginField = By.id("login");

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmpassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "dropdown-menu-roles")
    private WebElement rolesField;

    @FindBy(css = "button.b-button")
    private WebElement submitButton;

    private String url = "/users/edit/1";
    private List<WebElement> usersTable;


    public String getLoginField() {
        return loginField.getAttribute("value");
    }

    public UserEditPage setPassword(String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
        return this;
    }

    public UserEditPage setConfirmPassword(String text) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(text);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    private Select rolesDropdown() {
        return new Select(rolesField);
    }

    public String getRole() {
        return rolesField.getText();
    }

    public String getRole2() {
        return rolesDropdown().getFirstSelectedOption().getText();
    }

    public UserEditPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(byUserForm));
        return this;
    }
}
