import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UseraccountLoginTests {
    // import the selenium WebDriver
    private WebDriver driver;

    //functions before test commence
    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //lunch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website url
        driver.get ("https://www.facebook.com/");
        //wait for the page to load in 5 seconds
        Thread.sleep (5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        //Get page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        //Click on the username field and input a valid username "lige.634@gmail.com"
        driver.findElement(By.id("email")).sendKeys("lige.634@gmail.com");
        //locate the email field and use your own valid password "new;glory"
        driver.findElement(By.id("pass")).sendKeys("new;glory");
        //Click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        //wait to see users logged in page
        Thread.sleep(5000);
        //Test to confirm user logged in
        if(driver.getCurrentUrl().contains("https://web.facebook.com/?sk=welcome&_rdc=1&_rdr")){
            System.out.println("PASSED-User has successfully logged in'");
        }else{
            System.out.println("Failed-User was unable to login");
        }
        Thread.sleep(5000);
        //waiting to see logged in page
    }
    @Test
    public void logoutTest() throws InterruptedException {
        //click on the user profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i") ).click();
        Thread.sleep (5000);
        //click on the login button
        driver.findElement (By.xpath ("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click ();
        //Test to confirm user logged out
        if(driver.getCurrentUrl().contains("https://web.facebook.com/?stype=lo&jlou=AffkDOe4eqJy5aRttUO2zPAeK2TLnpECKju_YDbAL-Op3GQYFK8oGm1Rf6QW2r1yfjBx38xzlSA3e55dqRRkIWor6knhOpY9hBAcRheOQcf50A&smuh=41030&lh=Ac_k7xt_1Z4yhRFJKZE")) {
            System.out.println("PASSED-User has successfully logged out'");
        }else{
            System.out.println("Failed-User is still logged in");
        }
        Thread.sleep(5000);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}

