package automationpractice.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import automationpractice.pageobjects.MainPage;

import java.util.Optional;

import static org.junit.Assert.*;

public class MainPageSteps {
    private WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps() {
        driver = DriverManager.getInstance();
        mainPage = new MainPage();
    }

    @And("user types {} into search field")
    public void userTypesIntoSearchField(String keyword) {
        mainPage.getSearchField().sendKeys(keyword);
    }

    @Given("User has navigated to main page")
    public void userHasNavigatedToMainPage() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("user selects first suggestion")
    public void userSelectsFirstSuggestion() {
        mainPage.getFirstSearchSuggestion().click();
    }

    @Then("product page is displayed")
    public void productPageIsDisplayed() {
        assertTrue(mainPage.getProductContainer().isDisplayed());
    }

    @And("user clicks Dresses in menu")
    public void userClicksDressesInMenu() {
        mainPage.getMenuDresses().click();
    }

    @When("user sets catalog filters to")
    public void userSetsCatalogFiltersTo(DataTable data) {
        data.asList().forEach(s -> mainPage.getFilterElement(s).click());

    }

    @Then("product list contains items available in color {word}")
    public void productListContainsItemsAvailableInColor(String color) {
        Optional<WebElement> element = mainPage.getProductList().stream().filter(x -> findSubElement(x, By.cssSelector("a[href*='" + color.toLowerCase() + "']")) == null).findFirst();
        assertFalse("One ore more products were not available in color " + color, element.isPresent());
    }

    private WebElement findSubElement(WebElement x, By css) {
        try {
            return x.findElement(css);
        } catch (Exception e) {
            return null;
        }

    }

    @When("user executes search")
    public void userExecutesSearch() {
        mainPage.getSearchButton().click();
    }

    @Then("list of search results is displayed")
    public void listOfSearchResultsIsDisplayed() {
        assertFalse("Search result list is empty", mainPage.getProductList().isEmpty());
    }

    @And("user adds item {int} to comparison")
    public void userAddsAnItemToComparison(int id){
        Actions actions = new Actions(driver);
        actions.moveToElement(mainPage.getProductList().get(--id)).pause(1).moveToElement(mainPage.getAddToComparisonLinks().get(id)).click().build().perform();
        //small workaround for button activation
        driver.navigate().refresh();
    }

    @When("user clicks Compare")
    public void userClicksCompare() {
        mainPage.getCompareButton().click();
    }

    @Then("{int} items are displayed in comparing list")
    public void itemsAreDisplayedInComparingList(int amount) {
        int actualSize = mainPage.getComparisonList().size();
        assertEquals("Expected " + amount + " items in comparison, but found " + actualSize, actualSize, amount);

    }

    @And("user opens product page of the first result")
    public void userOpensProductPageOfTheFirstResult() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainPage.getProductList().get(0)).moveToElement(mainPage.getQuickViewIcon()).click().build().perform();
    }

    @When("user clicks Add to wishlist on product quick view")
    public void userClicksAddToWishlistOnProductPage() {
        driver.switchTo().frame(mainPage.getPopupIFrame());
        mainPage.getAddToWishlist().click();
    }

    @Then("user is notified of logging in requirement")
    public void userIsNotifiedOfLoggingInRequirement() {
        assertTrue("Error message is not displayed", mainPage.getErrorMessage().isDisplayed());
    }
}
