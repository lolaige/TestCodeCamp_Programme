package AddToCart;

import CheckOut.CheckOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private WebDriver driver;
    private By totalItemCount = By.xpath("//div[@class='a03ba_1Zj-T']");
    private By addItem = By.xpath("//button[@name='increment']");
    private By checkOutButton = By.xpath("//div[@class='_2aac2_3bwnD  _841f1_1RZK9']");

    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Check the item in the cart
    public void itemCount(int count) throws InterruptedException
    {
        //Convert value showing quantity of an item from String to integer and store in itemNumber variable
        int itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());

        //Compare the current quantity of an item with the expected quantity and increment until they equate each other
        while (itemNumber != count)
        {
            //Click the + button to increase the number of the selected item
            driver.findElement(addItem).click();
            //Update the value of the quantity in the variable after each increment
            itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());
        }
        //Wait for the check out button to load
        Thread.sleep(6000);
    }

    //Click on the check out button
    public CheckOutPage clickCheckOut() throws InterruptedException
    {
        driver.findElement(checkOutButton).click();
        //Wait for the checkout page to load
        Thread.sleep(5000);
        return new CheckOutPage(driver);
    }

}
