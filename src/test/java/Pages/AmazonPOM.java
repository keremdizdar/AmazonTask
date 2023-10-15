package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPOM {

    public AmazonPOM() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchIt;

    @FindBy(css = "[class^=a-size-base-plus]")
    private List<WebElement> listedProductCount;

    @FindBy(className = "a-price-whole")
    private WebElement firstHalfOfThePrice;

    @FindBy(xpath = "//*[text()='$50 to $100']")
    private WebElement fiftyToHundred;

    @FindBy(id = "productTitle")
    private WebElement selectedProduct;

    @FindBy(css= "[title^='Add']")
    private WebElement addToCart;

    @FindBy(id = "nav-cart-count")
    private WebElement goToCart;

    @FindBy(id = "sc-subtotal-amount-buybox")
    private WebElement basketPrice;

    @FindBy(name = "quantity")
    private WebElement selection;

    @FindBy(id = "sc-subtotal-label-buybox")
    private WebElement totalItemsCount;

    @FindBy(xpath = "(//*[@class='a-price-whole'])[1]")
    private WebElement firstHalfOfTheCurrentPrice;

    @FindBy(xpath = "(//*[@class='a-price-fraction'])[1]")
    private WebElement secondHalfOfTheCurrentPrice;


    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchIt() {
        return searchIt;
    }

    public List<WebElement> getListedProductCount() {
        return listedProductCount;
    }

    public WebElement getFirstHalfOfThePrice() {
        return firstHalfOfThePrice;
    }

    public WebElement getFiftyToHundred() {
        return fiftyToHundred;
    }

    public WebElement getSelectedProduct() {
        return selectedProduct;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getBasketPrice() {
        return basketPrice;
    }

    public WebElement getSelection() {
        return selection;
    }

    public WebElement getGoToCart() {
        return goToCart;
    }

    public WebElement getTotalItemsCount() {
        return totalItemsCount;
    }

    public WebElement getFirstHalfOfTheCurrentPrice() {
        return firstHalfOfTheCurrentPrice;
    }

    public WebElement getSecondHalfOfTheCurrentPrice() {
        return secondHalfOfTheCurrentPrice;
    }
}