package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SetupTests {
    //Create a WebDriver object
    private WebDriver driver;
    //Create a LoginPage object
    protected pageObjects.LoginPage loginPage;

    public void setUp(){
        //Setup browser for Chrome
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximise the browser
        driver.manage().window().maximize();
        //Launch the URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}
