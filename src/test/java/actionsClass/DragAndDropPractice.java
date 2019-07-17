package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DragAndDropPractice {

    @Test
    public void dragNdrop(){
        //1- get the page
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2- locating the webelements
        WebElement source = Driver.getDriver().findElement(By.id("draggable"));
        WebElement target = Driver.getDriver().findElement(By.id("droptarget"));

        //3-Create an object of Actions class.
        Actions actions = new Actions(Driver.getDriver());

        //4-Use actions object to execute dragAndDrop() method.
        actions.dragAndDrop(source, target).perform();

        //5-Assert the text is as expected
        String expectedText = "You did great!";
        String actualText = target.getText();

        Assert.assertEquals(actualText, expectedText);

        actions.clickAndHold(source).moveToElement(target).release().perform();


    }
}
