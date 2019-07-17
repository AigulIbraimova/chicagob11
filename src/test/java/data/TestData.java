package data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class TestData {

    @Test
    public void m() {

        Driver.getDriver().get("http://www.google.com");
        WebElement search = Driver.getDriver().findElement(By.name("q"));
        search.sendKeys(Config.getProperty("search") + Keys.ENTER);

    }

}
