package ru.st.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by a.shmelkov on 05.05.2017.
 */
public class MakeNewUsers extends TestBase {
    private User admin = new User()
            .setLogin("admin")
            .setPassword("admin");
    private User oti = new User()
            .setLogin("oti09")
            .setName("Winner")
            .setPassword("otb")
            .setRole("Оператор ОТИ")
            .setPhone("123")
            .setMetroStation("Каширская")
            .setMetroLine("Сокольническая линия");

    @BeforeMethod
    public void mayBeLogoutBefore() {
        if (app.getUserHelper().isNotLoggedIn()) {
            return;
        }
        app.getUserHelper().logout();
    }

    @AfterMethod
    public void mayBeLogoutAfter() {
        if (app.getUserHelper().isLoggedIn()) {
            app.getUserHelper().logout();
        }
    }

    @Test(description = "ID = <T01> Создать пользователя")
    public void test01() throws Exception {
        app.getUserHelper().loginAs(admin);
        app.getUserHelper().createNewUser(oti);
        assertTrue(app.getUserHelper().isUserInUsersTable(oti));

    }
}
