package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DoubleClick{

    Actions actions;

    @Test
    public void doubleClickTest() throws InterruptedException{
        //1- Get the page
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        //2- Locate the webElements
        WebElement puff = Driver.getDriver().findElement(By.id("puff_header"));
        //3- Create an object of the Actions class.
        actions = new Actions(Driver.getDriver());
        //4- Use the method coming from Actions class.
        actions.doubleClick(puff).perform();
        Thread.sleep(1000);
        Assert.assertTrue(!puff.isDisplayed());
        //Assert.assertFalse(puff.isDisplayed());


    }

    @Test
    public void doubleClickTest2(){


        // GETTING THE PAGE
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //SWITCHING TO THE IFRAME
        Driver.getDriver().switchTo().frame("iframeResult");
            //1- Locate the iframe as a webElement and pass it inside to frame()
            // WebElement iframe = driver.findElement(By.xpath("locator"));
            // driver.switchTo().frame(iframe);
            //2- pass the index number of the iframe. ==> switchTo().frame(0);
            //3- Pass the id or name attribute value --> switchTo().frame("attribute value of name/id");

        //LOCATING THE WEBELEMENT INSIDE OF THE IFRAME
        WebElement textToClick = Driver.getDriver().findElement(By.id("demo"));

        //INSTANTIATING THE INSTANCE OF ACTIONS CLASS
        actions = new Actions(Driver.getDriver());

        actions.doubleClick(textToClick).perform();

        System.out.println("Attribute value of style: " + textToClick.getAttribute("style"));

        Assert.assertTrue(textToClick.getAttribute("style").contains("red"));

    }

}
