package automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automationpractice.stepdefinitions.DriverManager;

import java.util.List;

public class MainPage {

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(css = ".ac_results li")
    private WebElement firstSearchSuggestion;

    @FindBy(css= ".sf-menu>li>.sf-with-ul[title='Dresses']")
    private WebElement menuDresses;

    @FindBy(css =  ".primary_block.row")
    private WebElement productContainer;

    @FindBy(css =  ".product_list.grid.row .ajax_block_product")
    private List<WebElement> productList;

    @FindBy(css =".add_to_compare:not(.checked)")
    private List<WebElement> addToComparisonLinks;

    @FindBy(css =  ".compare-form")
    private WebElement compareButton;

    @FindBy(css =  "#product_comparison .ajax_block_product")
    private List<WebElement> comparisonList;

    @FindBy(css =  "#wishlist_button")
    private WebElement addToWishlist;

    @FindBy(css =  ".fancybox-error")
    private WebElement errorMessage;

    @FindBy(css =  ".quick-view")
    private WebElement quickViewIcon;

    @FindBy(css =  ".fancybox-iframe")
    private WebElement popupIFrame;

    public WebElement getFilterElement(String label){
        return DriverManager.getInstance().findElement(By.xpath("//label/a[text() = '"+label+"']"));
    }

    public MainPage() {
        PageFactory.initElements(DriverManager.getInstance(), this);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getFirstSearchSuggestion() {
        return firstSearchSuggestion;
    }

    public WebElement getMenuDresses() {
        return menuDresses;
    }

    public WebElement getProductContainer() {
        return productContainer;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public List<WebElement> getAddToComparisonLinks() {
        return addToComparisonLinks;
    }

    public WebElement getCompareButton() {
        return compareButton;
    }

    public List<WebElement> getComparisonList() {
        return comparisonList;
    }

    public WebElement getAddToWishlist() {
        return addToWishlist;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getQuickViewIcon() {
        return quickViewIcon;
    }

    public WebElement getPopupIFrame() {
        return popupIFrame;
    }

}
