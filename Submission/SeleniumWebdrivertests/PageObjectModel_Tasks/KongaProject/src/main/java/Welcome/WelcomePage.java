package Welcome;

import Login.LoginPage;
import SubCategory.SubCategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WelcomePage {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']");
    private By categoryBarElement = By.className("ef511_2c5_i");
    private By subcategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //Category,where Category = "Computers and Accessories"
    int categoryNumber = 1;
    //Subcategory,  where Subcategory = "Laptops"
    int loginButtonElementID = 3;

    public WelcomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click on the Login/Sign up button on the landing page
    public LoginPage clickLoginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);
    }


    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);

        //Choose the category to move the mouse hover
        WebElement selectedCategory = driver.findElements(categoryBarElement).get(categoryNumber);
        //Hover over the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(10000);

        //Click on the Apple MacBooks Laptop
        driver.findElement(subcategory).click();
        Thread.sleep(5000);

        return new SubCategoryPage(driver);
    }
}

