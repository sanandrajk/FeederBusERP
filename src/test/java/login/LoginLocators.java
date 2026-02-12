package login;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginLocators {
    
    private Page page;
    private Locator loginEmailid;
    private Locator loginPassword;
    private Locator loginButton;
    private Locator actualErrorToast;
    private static Locator loginErrorText;

    public LoginLocators(Page page) {
        this.page = page;
        this.loginEmailid = page.locator("//input[@id='username']");
        this.loginPassword = page.locator("//input[@id='password']");
        this.loginButton = page.locator("//button[@type='submit']");
        this.loginErrorText = page.locator("//div[@class=\"error-message\"]");
    }



    public void enterLoginEmailid(String email) {
        loginEmailid.fill(email);
        System.out.println("Login email is entered");
    }
    public void enterLoginPassword(String password) {
        loginPassword.fill(password);
        System.out.println("Login password is entered");
    }
    public void clickLoginButton() {
        loginButton.click();
        System.out.println("Login button is clicked");
    }

    // Check whether login button is enabled (returns true if enabled)
    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    // Convenience wrapper: returns true if login button is disabled
    public boolean isLoginButtonDisabled() {
        return loginButton.isDisabled();
    }

    public String getLoginErrorText() {
        return loginErrorText.textContent();
    }

}
