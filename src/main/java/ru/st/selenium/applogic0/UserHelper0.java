package ru.st.selenium.applogic0;

import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.UserEditPage;

public class UserHelper0 extends DriverBasedHelper implements UserHelper {

    public UserHelper0(ApplicationManager0 manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void loginAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getPassword())
                .clickSubmitButton();
    }

    public void loginWithNewPasswordAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getNewPassword())
                .clickSubmitButton();
    }

    @Override
    public void changePassword(User user) {
        pages.userEditPage.ensurePageLoaded()
                .setPassword(user.getNewPassword())
                .setConfirmPassword(user.getNewPassword())
                .clickSubmitButton();
    }

    @Override
    public void changePasswordBack(User user) {
        pages.userEditPage.ensurePageLoaded()
                .setPassword(user.getPassword())
                .setConfirmPassword(user.getPassword())
                .clickSubmitButton();
    }

    @Override
    public void logout() {
        pages.internalPage.ensurePageLoaded()
                .clickLogoutLink();
    }

    @Override
    public void createNewUser(User user) {
        pages.internalPage.ensurePageLoaded()
                .clickUserPage();
        pages.userPage.ensurePageLoaded()
                .setCurrentUser(user);
    }

    @Override
    public boolean isLoggedIn() {
        return pages.internalPage.waitPageLoaded();
    }

    @Override
    public boolean isNotLoggedIn() {
        return pages.loginPage.waitPageLoaded();
    }

    @Override
    public boolean isLoggedInAs(User user) {
        return isLoggedIn()
                && getLoggedUser().getLogin().equals(user.getLogin());
    }

    private User getLoggedUser() {
        InternalPage internalPage = pages.internalPage.ensurePageLoaded(); // убеждаемся, что загрузилась внутренняя страница
        return new User()
                .setLogin(internalPage.getAdminBarUsername()); // создаем нового юзер пихаем в него имя из adminbar для дальнейшего его сравнения с настоящим юзером
    }

    @Override
    public boolean isLoginFieldOk(User user) {
//    UserEditPage userEditPage = pages.userEditPage.ensurePageLoaded();
        return pages.userEditPage.ensurePageLoaded().getLoginField().equals(user.getLogin());
    }

    @Override
    public boolean isRoleFieldOk(User user) {
        return pages.userEditPage.ensurePageLoaded().getRole().equals(user.getRole());
    }

    @Override
    public boolean isUserInUsersTable(User user) {
        return pages.userPage.ensurePageLoaded().getUserLogin(user).equals(user.getLogin());
    }
}
