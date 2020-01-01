package page_objects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import page_elements.filter_section.FiltersBlock;
import page_elements.items_grid.ItemTile;
import page_elements.items_grid.ItemsGrid;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ListItemsPage {
    protected ItemsGrid itemsGrid;
    protected FiltersBlock filterSidebar;

    public ListItemsPage() {
        Selenide.sleep(3000);
        itemsGrid = new ItemsGrid($$x("//div[@class='goods-tile']"));
        filterSidebar = new FiltersBlock($$x("//div[@class='sidebar-block']"));
    }

    private ItemTile getItemTile(int index) {
        return itemsGrid.getItemTiles().get(index);
    }


    public ListItemsPage setPriceRange(int min, int max) {

        SelenideElement minField = $x("//input[@formcontrolname='min']");
        minField.clear();
        minField.sendKeys(Integer.toString(min));

        SelenideElement maxField = $x("//input[@formcontrolname='max']");
        maxField.clear();
        maxField.sendKeys(Integer.toString(max));
        $x("//button[@type='submit']").click();
        return new ListItemsPage();
    }

    public ReviewsPage openReviewsPage(int itemIndex) {
        getItemTile(itemIndex).getReviewsLink().click();

        return new ReviewsPage();
    }

    // should be discussed is it correct to handle dialog windows
    // maybe it would be better to replace with page element e.g CheckoutDialogWindow
    public CheckoutDialogPage buyItem(int index) {
        getItemTile(index).getShoppingCartButton().click();

        return new CheckoutDialogPage();
    }

    public String getItemName(int index) {
        return getItemTile(index).getItemLink().getText();
    }

    public ItemPage openItemsPage(int index) {
        getItemTile(index).getItemLink().click();

        return new ItemPage();
    }

    public int getItemPrice(int index) {
        String price = getItemTile(index).getItemPrice();

        return Integer.parseInt(price.replaceAll(" ", ""));
    }

    public String getItemRate(int index) {
        return getItemTile(index).getRate();
    }

    public WishListPage addItemToWishList(int index) {
        getItemTile(index).getAddToWishListButton().click();

        return new WishListPage();
    }

    public ListItemsPage selectFilter(String filterTitle, String filterOptionTitle) {
        filterSidebar.selectFilter(filterTitle, filterOptionTitle);
        return new ListItemsPage();
    }

    public int getAmountOfFeedbacks(int index) {
        return Integer.parseInt(getItemTile(index).getReviewsLink().getText().replaceAll("\\D", ""));
    }


}
