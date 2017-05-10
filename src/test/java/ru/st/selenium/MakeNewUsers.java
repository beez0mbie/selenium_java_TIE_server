package ru.st.selenium;

import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

/**
 * Created by a.shmelkov on 05.05.2017.
 */
public class MakeNewUsers extends TestBase {
    private User admin = new User()
            .setLogin("admin")
            .setPassword("admin");
    private User oti = new User()
            .setLogin("oti")
            .setPassword("oti")
            .setRole("Оператор ОТИ")
            .setMetroStation("Планерная")
            .setName("loser")
            .setPhone("1111");

    @Test(description = "ID = <T01> Создать пользователя")
    public void test01() throws Exception {
        app.getUserHelper().loginAs(admin);
        app.getUserHelper().createNewUser(oti);

    }
}
