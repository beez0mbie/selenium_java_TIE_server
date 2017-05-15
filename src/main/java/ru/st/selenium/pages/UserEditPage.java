package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.User;

import java.util.List;
import java.util.NoSuchElementException;

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

//    @FindBy(css = ".Select-placeholder")
    @FindBy(xpath = "//*[@id=\"react-select-2--value\"]")
    private WebElement metroLineDropdown;

//    private By byMetroLineDropdown = By.cssSelector(".Select-placeholder");
    private By byMetroLineDropdown = By.xpath("//*[@id=\"react-select-2--value\"]");

//    @FindBy(css = ".Select-placeholder")
    @FindBy(xpath = "//*[@id=\"react-select-2--value\"]")
    private WebElement metroStationDropdown;

//    private By byMetroStationDropdown = By.cssSelector(".Select-placeholder");
    private By byMetroStationDropdown = By.xpath("//*[@id=\"react-select-2--value\"]");

    @FindBy(css = ".Select-control")
    private WebElement metroForm;

    @FindBy(css = "button.b-button")
    private WebElement submitButton;

    private String url = "/users/edit/1";

    private List<WebElement> metroStationList;

    private List<WebElement> usersTable;

    private List<WebElement> tables;

    private By byTables = By.xpath("//*[@id=\"user_form-1\"]/form/div/label");


    public String getLoginField() {
        return loginField.getAttribute("value");
    }

    public UserEditPage setLogin(String text) {
        loginField.clear();
        loginField.sendKeys(text);
        return this;
    }

    public UserEditPage setName(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
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

    public UserEditPage setPhone(String text) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(text);
        return this;
    }

    private String getMetroType() {
        tables = driver.findElements(byTables);
        for (WebElement table : tables) {
            if (table.getText().equals("Линия метро")) {
                return table.getText();
            }
            if (table.getText().equals("Станция метро")) {
                return table.getText();
            }
        }
        return null;
    }
    public UserEditPage setMetro(String text) {
        tables = driver.findElements(byTables);
        for (WebElement table : tables) {
            System.out.println(table.getText());
        }
        return this;
    }

    public UserEditPage setMetroStation(String text) {
        try {
            wait.until(presenceOfElementLocated(byMetroStationDropdown));
            if (metroStationDropdown.getText().equals("Выберите станцию")) {
                metroStationDropdown.click();
                metroStationDropdown.sendKeys(text);
                metroForm.sendKeys(Keys.ENTER);
                return this;
            } else {
                System.out.println("False (equals(\"Выберите станцию\"))");
                return this;
            }
        } catch (Exception e) {
            System.out.println("Не найден локатор byMetroStationDropdown");
            return this;
        }
    }

    public UserEditPage setMetroLine(String text) {
        try {
            wait.until(presenceOfElementLocated(byMetroLineDropdown));
            if (metroLineDropdown.getText().equals("Линий метро")) {
                metroLineDropdown.click();
                metroLineDropdown.sendKeys(text);
                metroForm.sendKeys(Keys.TAB);
                return this;
            } else {
                System.out.println("False (equals(\"Линий метро\"))");
                return this;
            }
        } catch (Exception e) {
            System.out.println("Не найден локатор byMetroLineDropdown");
            return this;
        }
    }

    public UserPage clickSubmitButton() {
        submitButton.click();
        return pages.userPage;
    }

//
//    private void metroStation(String text) {
//        metroStationList = driver.findElements(By.cssSelector(".Select-menu-outer"));
//        for (WebElement station : metroStationList) {
//            System.out.println(station);
//            if (station.getText().equals(text)) {
//                station.click();
//            }
//        }
//    }

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
