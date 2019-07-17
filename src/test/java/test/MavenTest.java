package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenTest {

    public static void main(String[] args) {

        //System.out.println("Hello, Maven!");

        //System.out.println(faker.name().name());

        //System.out.println(faker.phoneNumber());

        //we dont need to set the properties anymore
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        //System.out.println(faker.name());
        driver.get("https://google.com");

        driver.findElement(By.name("q"))
                .sendKeys(faker.name().name() + Keys.ENTER);

    }

}
