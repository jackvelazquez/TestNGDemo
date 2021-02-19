package JAC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class SeleniumTest {

    public static WebDriver driver;

    @Test
    public void  AmazonTitleTest()
    {
        System.out.println("Test Started...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Opening browser...");
        driver.get("https://www.amazon.com.mx/") ;

        System.out.println("Validating Title...");
        String expectedTitle = "Amazon.com.mx: Precios bajos - Envío rápido - Millones de productos";
        String actualTitle = driver.getTitle();

        System.out.println("    --> " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

        // Click Logo
        //https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
        WebElement objLogo = driver.findElement(By.id("nav-logo-sprites"));
        objLogo.click();

        WebElement objSearch = driver.findElement(By.id("twotabsearchtextbox"));
        objSearch.sendKeys("Stan Lee Dorado");

        WebElement objSearchBtn = driver.findElement(By.id("nav-search-submit-button"));
        objSearchBtn.click();

        System.out.println("Closing Browser...");
        driver.close();
        System.out.println("Test Completed");
    }


}
