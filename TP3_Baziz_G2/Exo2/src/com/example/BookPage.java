package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookPage extends PageObject {

    @FindBy(css= ".ux-call-to-action.fake-btn.fake-btn--fluid.fake-btn--primary")
    private WebElement CartButton;

    @FindBy(id="gh-cart-n")
    private WebElement ItemsNum;

   @FindBy (css="span.text-display-span > span:nth-child(1)")
    private List<WebElement> price;


    public BookPage(WebDriver driver) {
        super(driver);
    }
    public String ItemsNumber(){
        return ItemsNum.getText();
    }
    public String price(){
        return(price.get(15).getText());
    }

    public void AddtoCart(){
       CartButton.click();
    }

}