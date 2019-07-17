package testng;

import org.testng.annotations.Test;

public class OrderOfThings {

    //@BeforeMethod
    public void setUp(){
        System.out.println("Before method running.");
    }

    @Test(priority = 1, dependsOnMethods = "secondTest")
    public void firstTest(){
        System.out.println("First test is running");
    }

    @Test(priority = 2)
    public void secondTest(){
        System.out.println("Second test is running");
    }

    @Test(priority = 3)
    public void thirdTest(){
        System.out.println("Third test is running");
    }
}
