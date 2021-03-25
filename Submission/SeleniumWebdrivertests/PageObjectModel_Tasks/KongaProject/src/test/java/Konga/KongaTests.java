package Konga;

import Search.SearchPage;
import Setup.SetupTest;
import org.testng.annotations.Test;

import java.util.Random;

public class KongaTests extends SetupTest {
    @Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1, numberOfItems = 1;
        String userId = "Input Username", password = "Input Password", item = "Apple MacBooks",
                cardNumber = "5113 0000 3222 8800", date = "04/23", cvv = "101";
        //Create random class
        Random random = new Random();

        try {
            //Sign in to Konga website
            //Replace the class type name 'LoginPage' with 'var'
            var loginPage = welcomePage.clickLoginSignUpButton();
            //Replace the username and password string with valid user details
            loginPage.enterUsername(userId);
            loginPage.enterPassword(password);
            //Click on Login Button
            loginPage.clickLoginButton();
            //Select the category and subcategory
            var subCategoryPage =welcomePage.clickCategoryAndSub();
            //Use the search box to search for an item
            subCategoryPage.searchForAnItem(item);
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //Click on the add to cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //Click on My Cart button
            var addToCartPage = searchPage.clickMyCartButton();
            addToCartPage.itemCount(numberOfItems);
            //Click on checkout
            var checkOutPage = addToCartPage.clickCheckOut();
            //Click on the "Pay Now" button to enable the “Continue to Payment” button - the user must have preselected pick up method
            checkOutPage.clickOnPayNow();
            //Click on the “Continue to Payment” button
            checkOutPage.clickContinueToPayment();
            //Select the “CARD” payment method
            checkOutPage.clickOnPaymentType();
            //Enter a wrong card number, date, CVV
            checkOutPage.enterCardDetails(cardNumber, date , cvv);

            //Print out the error message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
