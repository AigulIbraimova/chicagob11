package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ScrollingExamples {

    Actions actions;

    @Test
    public void scrollUsingMoveTo(){
        //1- Getting the page
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

        //2- Locating the webElement
        WebElement footer = Driver.getDriver().findElement(By.className("footer-info-left"));

        //3- Creating the Actions class object
        actions = new Actions(Driver.getDriver());

        //4- Use actions object and moveToElement method to scroll to target WebElement.
        actions.moveToElement(footer).perform();


    }

    @Test
    public void scrollUsingKeys() throws InterruptedException{
        //1- Getting the page
        Driver.getDriver().get("https://youtube.com");
        Thread.sleep(2000);
        //2- Create actions class object.
        actions = new Actions(Driver.getDriver());

        //3- Sending Keys using actions object.
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();



    }

    @Test
    public void scrollUsingJSExecutor(){

        //1- Getting the page
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

        //2- JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000);");

    }


}
