package Web.Pages;

import Web.Util.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Page {

    private By firstnameField = By.name("firstname");
    private By lastnameField = By.name("lastname");
    private By maleGenderButton = By.xpath("//input [@type='radio' and @value=2]");
    private By dayDDL = By.id("day");
    private By monthDDL = By.id("month");
    private By yearDDL = By.id("year");
    private By emailField = By.name("reg_email__");
    private By passwordField = By.name("reg_passwd__");
    private By submitButton = By.name("websubmit");
    private By validationMessage = By.id("js_2mv");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step(" Open Registration page")
    public RegistrationPage openRegPage(){
        openURL(URLs.FACEBOOK_REGISTRATION.getValue());
        return this;
    }

    @Step("-enter first name")
    public RegistrationPage enterFirstName(String firstname) {
        sendText(firstnameField, firstname);
        return this;
    }

    @Step("-enter last name")
    public RegistrationPage enterLastName(String lastname) {
        sendText(lastnameField, lastname);
        return this;
    }

    @Step("-select day")
    public RegistrationPage selectDay(String option) {
        selectElementFromDDL(dayDDL, option);
        return this;
    }

    @Step("-select month")
    public RegistrationPage selectMonth(String option) {
        selectElementFromDDL(monthDDL, option);
        return this;
    }

    @Step("-select year")
    public RegistrationPage selectYear(String option) {
        selectElementFromDDL(yearDDL, option);
        return this;
    }

    @Step("-select Gender - Male") //Todo: enhance it to be dynamic not static
    public RegistrationPage selectMaleGender() {
        clickElement(maleGenderButton);
        return this;
    }

    @Step("-enter email")
    public RegistrationPage enterEmailName(String email) {
        sendText(emailField, email);
        return this;
    }

    @Step("-enter password")
    public RegistrationPage enterPasswordName(String password) {
        sendText(passwordField, password);
        return this;
    }

    @Step("-click on submit and register")
    public RegistrationPage clickOnSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    @Step("-get the validation message")
    public String getTheValidationMessage() throws InterruptedException {
        Thread.sleep(1000);
        return getElementTextUsingJS(validationMessage);
//        return getElementText(validationMessage);
    }

}
