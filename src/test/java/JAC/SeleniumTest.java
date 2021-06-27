package JAC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    //TESPLAN

    @Test (priority=2, groups="regression")
    public void  RegressionTest1()
    {
        System.out.println("Regression Test 1 - priority 2");
        Assert.assertTrue(true);
    }

    @Test (priority=1, groups="regression")
    public void  RegressionTest2()
    {
        System.out.println("Regression Test 2 - priority 1");
        Assert.assertTrue(true);
    }

    @Test (priority=3, groups={"regression","sanity"})
    public void  RegressionTest3()
    {
        System.out.println("Regression & Sanity Test Group started");
        Assert.assertTrue(true);
    }

    @Test (priority=4, groups={"e2e", "sanity", "regression"})
    @Parameters({"param1"})
    public void  AmazonTitleTest(String param1)
    {

        System.out.println("Amazon Title Test started");
        System.out.println("Parameter passed to class --> " + param1);

        //Starts the web driver
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Opening browser...");
        driver.get("https://www.amazon.com.mx/") ;

        System.out.println("Validating Title...");
        String expectedTitle = "Amazon.com.mx: Precios bajos - Envío rápido - Millones de productos";
        // String actualTitle = driver.getTitle();
        String actualTitle = "Amazon.com.mx: Precios bajos - Envío rápido - Millones de productos";

        System.out.println("    --> " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

        // Click Logo
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

