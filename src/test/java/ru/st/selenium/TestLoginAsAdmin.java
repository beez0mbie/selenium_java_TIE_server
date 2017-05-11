package ru.st.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.assertTrue;

/**
 * Created by a.shmelkov on 04.05.2017.
 */
public class TestLoginAsAdmin extends TestBase {

    private User user = new User()
            .setLogin("admin")
            .setPassword("admin")
            .setNewPassword("1232334546547")
            .setRole("Администратор");

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

    @Test(description = "ID = <T01> Проверка авторизации")
    public void test01() throws Exception {
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user), "success loginPage as \"" + user.getLogin() + "\"");
    }

    @Test(description = "ID = <T02> Проверка авторизации с нужной ролью")
    public void test02() throws Exception {
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user), "success loginPage as \"" + user.getLogin() + "\"");
        app.getNavigationHelper().gotoUserEditPage();
        assertTrue(app.getUserHelper().isLoginFieldOk(user), "success loginField as \"" + user.getLogin() + "\"");
        assertTrue(app.getUserHelper().isRoleFieldOk(user), "success roleField as \"" + user.getRole() + "\"");
    }

    @Test(description = "ID = <T03> Изменение пароля")
    public void test03() throws Exception {
        app.getUserHelper().loginAs(user);
        app.getNavigationHelper().gotoUserEditPage();
        app.getUserHelper().changePassword(user);
        assertTrue(app.getUserHelper().isUserInUsersTable(user), "success change password for current user");
        app.getUserHelper().logout();
        app.getUserHelper().loginWithNewPasswordAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user), "success loginPage as %username%");
    }

    @Test(description = "ID = <T04> Проверка логина со старым паролем и его возвращение обратно" )
    public void test04() throws Exception{
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isNotLoggedIn());
        app.getUserHelper().loginWithNewPasswordAs(user);
        app.getNavigationHelper().gotoUserEditPage();
        app.getUserHelper().changePasswordBack(user);
//        assertTrue(app.getUserHelper().isUserInUsersTable(user), "success change password for current user");
        app.getUserHelper().logout();
        app.getUserHelper().loginWithNewPasswordAs(user);
        assertTrue(app.getUserHelper().isNotLoggedIn());
    }
}
