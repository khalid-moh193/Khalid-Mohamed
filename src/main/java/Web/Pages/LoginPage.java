package Web.Pages;

import Web.Util.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.id("loginbutton");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(" Open Login page")
    public LoginPage openLoginPage(){
        openURL(URLs.FACEBOOK_LOGIN.getValue());
        return this;
    }

    @Step("-enter first name")
    public LoginPage enterEmailName(String email) {
        sendText(emailField, email);
        return this;
    }

    @Step("-enter last name")
    public LoginPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    @Step("-click on login button")
    public LoginPage clickOnLoginButton() {
        clickElement(loginButton);
        return this;
    }

}
