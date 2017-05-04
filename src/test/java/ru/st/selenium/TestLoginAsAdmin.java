package ru.st.selenium;

import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by a.shmelkov on 04.05.2017.
 */
public class TestLoginAsAdmin extends TestBase{

    private User user = new User().setLogin("admin").setPassword("admin").setNewPassword("admin").setRole("Администратор");

    @Test(description = "ID = <T01> Проверка авторизации")
    public void test01() throws Exception {
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user), "success loginPage as %username%");
    }
}
