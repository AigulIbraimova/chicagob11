package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTestNG {

    @Test (priority = 2)
    public void login(){
        System.out.println("logging in...");
        Assert.fail("On purpose fail ");
    }

    @Test(priority = 1, dependsOnMethods = "login")
    public void makePurchase(){
        System.out.println("making the purchase...");
    }


    @Test(dependsOnMethods = "makePurchase" )
    public void homePage(){
        System.out.println("homePage tested");
    }
}
