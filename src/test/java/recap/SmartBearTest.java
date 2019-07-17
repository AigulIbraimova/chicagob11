package recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.SmarbearLink;
import utilities.TestBase;

public class SmartBearTest extends TestBase {

    public static void removeName(WebDriver driver, String name){

        String word = "word";
        String sentence = "//xpath"+word+"rest of the xpath";

        WebElement nameCheckBox = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='"+name+"']/../td[1]"));
        nameCheckBox.click();
        WebElement deleteButton = driver.findElement(By     .id("ctl00_MainContent_btnDelete"));
        deleteButton.click();
    }

    @Test
    public void smartTest() throws InterruptedException{

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmarbearLink.loginToSmartbear(driver);
        Thread.sleep(2000);
        removeName(driver, "Steve Johns");



    }
}
