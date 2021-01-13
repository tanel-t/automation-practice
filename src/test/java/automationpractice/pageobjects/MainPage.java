package automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automationpractice.stepdefinitions.DriverManager;

import java.util.List;

public class MainPage {

    @FindBy(id = "search_query_top")
    public WebElement searchField;

    @FindBy(name = "submit_search")
    public WebElement searchButton;

    @FindBy(css = ".ac_results li")
    public WebElement firstSearchSuggestion;

    @FindBy(css= ".sf-menu>li>.sf-with-ul[title='Dresses']")
    public WebElement menuDresses;

    @FindBy(css =  ".primary_block.row")
    public WebElement productContainer;

    @FindBy(css =  ".product_list.grid.row .ajax_block_product")
    public List<WebElement> productList;

    @FindBy(css =".add_to_compare:not(.checked)")
    public List<WebElement> addToComparisonLinks;

    @FindBy(css =  ".compare-form")
    public WebElement compareButton;

    @FindBy(css =  "#product_comparison .ajax_block_product")
    public List<WebElement> comparisonList;

    @FindBy(css =  "#wishlist_button")
    public WebElement addToWishlist;

    @FindBy(css =  ".fancybox-error")
    public WebElement errorMessage;

    @FindBy(css =  ".quick-view")
    public WebElement quickViewIcon;

    @FindBy(css =  ".fancybox-iframe")
    public WebElement popupIFrame;

    public WebElement getFilterElement(String label){
        return DriverManager.getInstance().findElement(By.xpath("//label/a[text() = '"+label+"']"));
    }
    public MainPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

}
