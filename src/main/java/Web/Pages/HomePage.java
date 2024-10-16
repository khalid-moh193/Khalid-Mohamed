package Web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public By shopsTab = By.id("comp-iy4cwgmq1label");

    public HomePage(WebDriver driver) {
        super(driver);
    }



}
