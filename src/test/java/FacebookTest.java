import Web.Pages.LoginPage;
import Web.Pages.RegistrationPage;
import Web.Util.URLs;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Login and Registration")
public class FacebookTest extends BaseTestClass {

    RegistrationPage registrationPage;
    LoginPage loginPage;


    @Test(description = " verify that registration is working fine")
    public void RegisterWithInvalidData() throws InterruptedException {
        registrationPage = new RegistrationPage(driver);

        registrationPage.openRegPage()
                .enterFirstName("Khalid")
                .enterLastName("Mohamed")
                .enterEmailName("test")
                .enterPasswordName("12345678aA!")
                .selectMaleGender()
                .selectDay("5")
                .selectMonth("11")
                .selectYear("1993")
                .clickOnSubmitButton();

        softAssert.assertTrue(registrationPage.getCurrentUrl().contains(URLs.FACEBOOK_REGISTRATION.getValue()), "URL has been changed, make sure that the registration is not completed");
        softAssert.assertEquals(registrationPage.getTheValidationMessage(), "bla bla");
        softAssert.assertAll();
    }

    @Test(description = " verify that registration is working fine")
    public void RegisterWithValidData() {

        registrationPage = new RegistrationPage(driver);

        registrationPage.openRegPage()
                .enterFirstName("test")
                .enterLastName("user")
                .enterEmailName("test@test.com")
                .enterPasswordName("12345678aA!")
                .selectMaleGender()
                .selectDay("5")
                .selectMonth("11")
                .selectYear("1993")
                .clickOnSubmitButton();

        softAssert.assertFalse(registrationPage.getCurrentUrl().contains(URLs.FACEBOOK_REGISTRATION.getValue()), "URL didn't change, make sure that the registration is completed");

        softAssert.assertAll();

    }

    @Test(description = " verify that Login is working fine, and redirects to home page")
    public void LoginWithValidCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .enterEmailName("test@test.com")
                .enterPassword("12345678aA!")
                .clickOnLoginButton();

    }

}
