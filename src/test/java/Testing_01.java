import Pages.AmazonPOM;
import Pages.Parent;
import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Testing_01 extends BaseDriver {

    AmazonPOM aPOM = new AmazonPOM();
    Parent PR = new Parent();

    @Test
    public void test1() {

        getDriver().get("https://www.amazon.com/");

        PR.sendKeysFunction(aPOM.getSearchBox(), "glasses");
        PR.clickFunction(aPOM.getSearchIt());
        aPOM.getSearchBox().clear();
        aPOM.getSearchBox().sendKeys("sun glasses" + Keys.ENTER);

        int randomNumber = (int) (Math.random() * aPOM.getListedProductCount().size());
        PR.clickFunction(aPOM.getListedProductCount().get(randomNumber));

        int priceOne = Integer.parseInt(aPOM.getFirstHalfOfThePrice().getText());


        if (priceOne > 1) {

            getDriver().navigate().back();
            PR.clickFunction(aPOM.getFiftyToHundred());

            int listedProductCount = aPOM.getListedProductCount().size();
            PR.clickFunction(aPOM.getListedProductCount().get(0));

            String selectedProduct = aPOM.getSelectedProduct().getText();
            String currentPrice = " $" + aPOM.getFirstHalfOfTheCurrentPrice().getText() + "." + aPOM.getSecondHalfOfTheCurrentPrice().getText();

            try {
                FileWriter FW = new FileWriter("C:/Users/Kerem/Documents/results.txt");
                BufferedWriter BW = new BufferedWriter(FW);

                BW.write("There are " + listedProductCount + " items in the pool");
                BW.newLine();
                BW.write("The Product Information is " + selectedProduct);
                BW.newLine();
                BW.write("The item's price is " + currentPrice);
                BW.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            PR.clickFunction(aPOM.getAddToCart());
            PR.clickFunction(aPOM.getGoToCart());

            String basketPrice = aPOM.getBasketPrice().getText();
            Assert.assertEquals(basketPrice, currentPrice);

            Select select = new Select(aPOM.getSelection());
            select.selectByVisibleText("2");


            Parent.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Delete']")));    // Sitenin ana bekletmesi olarak kullandım
            String expectedResult = "Subtotal (2 items):";
            Assert.assertEquals(expectedResult, aPOM.getTotalItemsCount().getText());


        } else {

            System.out.println("The item you selected is cheaper than 15$. Try again");

        }

        quitDriver();
    }

}