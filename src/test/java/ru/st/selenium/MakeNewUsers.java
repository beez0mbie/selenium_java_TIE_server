package ru.st.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by a.shmelkov on 05.05.2017.
 */
public class MakeNewUsers extends TestBase {

    private User admin = new User()
            .setLogin("admin")
            .setPassword("admin");
    private User oti = new User()
            .setLogin("oti03")
            .setName("Иванов Иван Иванович")
            .setPassword("oti")
            .setRole("Оператор ОТИ")
            .setPhone("8-800-555-35-35")
            .setMetroStation("Каширская")
            .setMetroLine("Сокольническая линия");

    private User otb = new User()
            .setLogin("otb02")
            .setName("Mr. Sexual Provider")
            .setPassword("otb")
            .setRole("Оператор ОТБ")
            .setPhone("+79090006699")
            .setMetroStation("Каширская")
            .setMetroLine("Сокольническая линия");

    private User dispetcher = new User()
            .setLogin("disp02")
            .setName("ЛЮДКА ХЛЕБО-БОРОДИНА")
            .setPassword("disp")
            .setRole("Диспетчер")
            .setPhone("0006699")
            .setMetroStation("Планерная")
            .setMetroLine("Таганско-Краснопресненская линия");

    private User od = new User()
            .setLogin("od02")
            .setName("H4ck the %хакерман;%?$\\//<>`(){[0]}")
            .setPassword("disp")
            .setRole("Оперативный дежурный")
            .setPhone("0000000000")
            .setMetroStation("Планерная")
            .setMetroLine("Таганско-Краснопресненская линия");


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
//        ArrayList<User> users = new ArrayList<User>();
//        users.add(oti);
//        users.add(otb);
//        users.add(dispetcher);
//        users.add(od);
//        for (User user : users) {
            app.getUserHelper().loginAs(admin);
            app.getUserHelper().createNewUser(oti);
            assertTrue(app.getUserHelper().isUserInUsersTable(oti));
            app.getUserHelper().logout();
//        }

    }
}
