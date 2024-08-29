package tests;

import com.example.BookPage;
import com.example.BooksListPage;
import com.example.SearchPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class EbayTest {
    static WebDriver driver;

    @Test
    public void Ebay(){
        SearchPage SearchPage = new SearchPage(driver);
        SearchPage.enterValues("python in easy steps","267");
        SearchPage.submit();

        BooksListPage BooksList = new BooksListPage(driver);
        BooksList.SelectBook();

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }



        BookPage BookPage = new BookPage(driver);
        BookPage.AddtoCart();

        String lien = driver.getCurrentUrl();
        assertEquals(lien,"https://cart.payments.ebay.com/");

        String ItemsNum = BookPage.ItemsNumber();
        assertEquals(ItemsNum,"1");

        String price = BookPage.price();
        assertEquals("US $9.99",price);
    }


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Desktop\\S1-SIL\\OGL\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.ebay.com");
    }
    @AfterClass

    public static void close() {
        driver.quit();
    }



}