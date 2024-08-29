import com.example.BookPage;
import com.example.BooksListPage;
import com.example.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {
    WebDriver driver;
    SearchPage SearchPage;
    BooksListPage BooksList;
    BookPage BookPage;

    @Given("User is on search page")
    public void userIsOnSearchPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Desktop\\S1-SIL\\OGL\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        SearchPage = new SearchPage(driver);
    }

    @When("I enter book {string} and I select the category of books {string}")
    public void iEnterBookAndISelectTheCategoryOfBooks(String book, String category) {

        SearchPage.enterValues(book, category);
        SearchPage.submit();

    }
    @And("I select the book")
    public void iSelectTheBook() {
        BooksList = new BooksListPage(driver);
        BooksList.SelectBook();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    @And("I click on the add button")
    public void iClickOnTheAddButton() {
        BookPage = new BookPage(driver);
        BookPage.AddtoCart();
    }
    
    @Then("The book is displayed on{string} and its price is {double} and the items number is {int}")
    public void theBookIsDisplayedOnAndItsPriceIsAndTheItemsNumberIs(String link, int Expectedprice, int ExpectedItemNum) {
        String lien = driver.getCurrentUrl();
        assertEquals(link,lien);

        String currentItemsNum = BookPage.ItemsNumber();
        assertEquals(ExpectedItemNum,currentItemsNum);

        String currentPrice = BookPage.price();
        assertEquals(Expectedprice,currentPrice);

        driver.quit();
    }
}