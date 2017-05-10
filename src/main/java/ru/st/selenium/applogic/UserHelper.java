package ru.st.selenium.applogic;

import ru.st.selenium.model.User;

public interface UserHelper {

    void loginAs(User user);

    void logout();

    void loginWithNewPasswordAs(User user);

    void changePassword(User user);

    void changePasswordBack(User user);

    boolean isLoggedIn();

    boolean isLoggedInAs(User user);

    boolean isNotLoggedIn();

    boolean isLoginFieldOk(User user);

    boolean isRoleFieldOk(User user);

    boolean isUserInUsersTable(User user);

    void createNewUser(User oti);
}
