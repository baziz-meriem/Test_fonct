package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends PageObject {

    @FindBy(id = "gh-cat")
    private WebElement Select;
    Select sel = new Select(Select);

    @FindBy(how = How.NAME, using = "_nkw")
    private WebElement SearchBar;

//        Select sel = new Select(driver.findElement(By.id("gh-cat")));
//        sel.selectByValue("267");
//        WebElement searchBar = driver.findElement(By.name("_nkw"));
//        searchBar.sendKeys("python in easy steps");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void enterValues(String SearchedItem, String ItemCategory){
        sel.selectByVisibleText(ItemCategory);
        SearchBar.sendKeys(SearchedItem);

        }
    public void submit(){
        SearchBar.submit();
    }
}