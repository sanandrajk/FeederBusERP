package login;
import com.microsoft.playwright.*;

import beforeMethod.SetupBrowser;
import dashboard.DashboardLocators;

import org.testng.Assert;
import org.testng.annotations.*;
    
public class LoginTest extends SetupBrowser {
    private LoginLocators locate;
    private DashboardLocators dash;

    @BeforeMethod
    public void init() {
        locate = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
    }

    @Test
    public void loginWithValidCred() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        Thread.sleep(3000);
        String actualText = dash.dashboardText();
        Assert.assertEquals(values.Values.DASHBOARD_PAGE_METRO_TEXT, actualText);
        System.out.println("Login Successful, Dashboard page is displayed");
    }

    @Test
    public void loginWithInvalidCred() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.INVALID_LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.INVALID_LOGIN_PASSWORD);
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_INVALID_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.INVALID_LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_INVALID_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithInvalidPassword() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.INVALID_LOGIN_PASSWORD);
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_INVALID_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithEmptyUsername() throws InterruptedException {
        locate.enterLoginEmailid("");
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_FOR_EMPTY_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword("");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_FOR_EMPTY_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithEmptyInputs() throws InterruptedException {
        locate.enterLoginEmailid("");
        locate.enterLoginPassword("");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, values.Values.EXPECTED_ERROR_TEXT_FOR_EMPTY_LOGIN);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginButtonDisabledWithoutInput() throws InterruptedException {
        Thread.sleep(3000); // small wait to ensure page is loaded
        boolean isDisabled = locate.isLoginButtonDisabled();
        System.out.println("Login button disabled state (no input): " + isDisabled);
        Assert.assertTrue(isDisabled, "Login button should be disabled when no login input is entered");
    }

    @Test
    public void loginButtonEnabledAfterInput() throws InterruptedException {
        // Enter valid input fields and verify the login button becomes enabled
        locate.enterLoginEmailid(values.Values.LOGIN_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        // small wait for inputs to process & UI to enable the button
        Thread.sleep(500);
        boolean isEnabled = locate.isLoginButtonEnabled();
        System.out.println("Login button enabled state (after input): " + isEnabled);
        Assert.assertTrue(isEnabled, "Login button should be enabled after valid inputs are entered");
    }

    @Test
    public void loginWithValidCredCaseSensitive() throws InterruptedException {
        locate.enterLoginEmailid(values.Values.LOGIN_UPPERCASE_EMAIL);
        locate.enterLoginPassword(values.Values.LOGIN_PASSWORD);
        locate.clickLoginButton();
        Thread.sleep(3000);
        String actualText = dash.dashboardText();
        Assert.assertEquals(values.Values.DASHBOARD_PAGE_METRO_TEXT, actualText);
        System.out.println("Login Successful, Dashboard page is displayed");
    }


}
