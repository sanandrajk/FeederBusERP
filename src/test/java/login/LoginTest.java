package login;
import com.microsoft.playwright.*;

import beforeMethod.SetupBrowser;
import dashboard.DashboardLocators;

import org.testng.Assert;
import org.testng.annotations.*;
    
public class LoginTest extends SetupBrowser {

    public static String expectedErrorText = "Invalid username or password";
    public static String expectedErrorTextForEmpty = "Please enter both username and password";

    private LoginLocators locate;
    private DashboardLocators dash;

    @BeforeMethod
    public void init() {
        locate = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
    }

    @Test
    public void loginWithValidCred() throws InterruptedException {
        locate.enterLoginEmailid("sanand@mailinator.com");
        locate.enterLoginPassword("Sanand@123");
        locate.clickLoginButton();
        Thread.sleep(3000);
        String actualText = dash.dashboardText();
        Assert.assertEquals("Metro Connect", actualText);
        System.out.println("Login Successful, Dashboard page is displayed");
    }
//test
    @Test
    public void loginWithInvalidCred() throws InterruptedException {
        locate.enterLoginEmailid("santhosh@mailinator.com");
        locate.enterLoginPassword("Santhosh@123");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorText);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        locate.enterLoginEmailid("santhosh@mailinator.com");
        locate.enterLoginPassword("Sanand@123");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorText);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithInvalidPassword() throws InterruptedException {
        locate.enterLoginEmailid("sanand@mailinator.com");
        locate.enterLoginPassword("Santhosh@123");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorText);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithEmptyUsername() throws InterruptedException {
        locate.enterLoginEmailid("");
        locate.enterLoginPassword("Sanand@123");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorTextForEmpty);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        locate.enterLoginEmailid("sanand@mailinator.com");
        locate.enterLoginPassword("");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorTextForEmpty);
        System.out.println("Login Failed, Error message is displayed as expected");
    }

        @Test
        public void loginWithEmptyInputs() throws InterruptedException {
        locate.enterLoginEmailid("");
        locate.enterLoginPassword("");
        locate.clickLoginButton();
        String actualError = locate.getLoginErrorText();
        Assert.assertEquals(actualError, expectedErrorTextForEmpty);
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
        locate.enterLoginEmailid("sanand@mailinator.com");
        locate.enterLoginPassword("Sanand@123");
        // small wait for inputs to process & UI to enable the button
        Thread.sleep(500);
        boolean isEnabled = locate.isLoginButtonEnabled();
        System.out.println("Login button enabled state (after input): " + isEnabled);
        Assert.assertTrue(isEnabled, "Login button should be enabled after valid inputs are entered");
    }

    @Test
    public void loginWithValidCredCaseSensitive() throws InterruptedException {
        locate.enterLoginEmailid("SANAND@MAILINATOR.COM");
        locate.enterLoginPassword("Sanand@123");
        locate.clickLoginButton();
        Thread.sleep(3000);
        String actualText = dash.dashboardText();
        Assert.assertEquals("Metro Connect", actualText);
        System.out.println("Login Successful, Dashboard page is displayed");
    }


}
