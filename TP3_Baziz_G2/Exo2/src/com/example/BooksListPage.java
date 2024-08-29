package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksListPage extends PageObject {
    @FindBy(xpath= "//*[text()='Python in easy steps by Mike McGrath 1840785969 The Fast Free Shipping']")
    private WebElement Book;


    public BooksListPage(WebDriver driver) {
        super(driver);
    }

    public void SelectBook(){
        Book.click();
    }
}