package Setup;

import Welcome.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class SetupTest {
    private WebDriver driver;
    public WelcomePage welcomePage;

    //Initialize WebDriver, launch the browser then go to the URL before performing the test
    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\TestCodeCamp_Programme\\Submission\\SeleniumWebdrivertests\\PageObjectModel_Tasks\\KongaProject\\resources\\chromedriver.exe");
        //This initializes WebDriver
        driver = new ChromeDriver();

        //Maximize web browser
        driver.manage().window().maximize();
        //Open URL on browser
        driver.get("https://www.konga.com/");
        welcomePage = new WelcomePage(driver);
    }

    //Close WebDriver and the browser after the test has been completed
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}

