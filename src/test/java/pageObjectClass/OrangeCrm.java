package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

import java.util.List;

public class OrangeCrm {

    @Ignore
    @Test
    public void loginVerification(){

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        Driver.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
        Driver.getDriver().findElement(By.id("txtPassword")).sendKeys("admin123");
        Driver.getDriver().findElement(By.id("btnLogin")).click();

        WebElement welcomeLink = Driver.getDriver().findElement(By.id("welcome"));
        Assert.assertTrue(welcomeLink.isDisplayed());

    }

    @Ignore
    @Test
    public void orangeLoginVerification(){
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        LoginPage olp = new LoginPage();

//        olp.usernameInput.sendKeys("Admin");
//        olp.passwordInput.sendKeys("admin123");
//        olp.loginButton.click();

        olp.orangeLogin("Admin","admin123");

        HomePage ohp = new HomePage();

        Assert.assertTrue(ohp.welcomeText.isDisplayed());

    }

    @Test
    public void verifyCEO() throws InterruptedException{
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        LoginPage olp = new LoginPage();
        //logged in to orangeHRM
        olp.orangeLogin("Admin", "admin123");

        //Create an instance of HomePage
        HomePage ohp = new HomePage();

        //Creating the instance of actions class to be able to hover over
        Actions actions = new Actions(Driver.getDriver());

        //Using the instance of HomePage, passing inside to actions
        Thread.sleep(2000);
        actions.moveToElement(ohp.performance).perform();
        Thread.sleep(2000);
        actions.moveToElement(ohp.configure).perform();
        Thread.sleep(2000);
        ohp.kpi.click();

        Select select = new Select(ohp.jobTitleDropdown);

        List<WebElement> options = select.getOptions();
        boolean found = false;

        for(WebElement option: options){
            System.out.println(option.getText());
            if(option.getText().equals("CEO")){
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);








    }

}
