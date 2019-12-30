package page_objects;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import page_elements.filter_section.Filter;
import page_elements.filter_section.FiltersBlock;
import page_elements.items_grid.ItemTile;
import page_elements.items_grid.ItemsGrid;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ListItemsPage {
    private ItemsGrid itemsGrid;
    private FiltersBlock  filterSidebar;

    public ListItemsPage(){
        Selenide.sleep(4000);
        itemsGrid = new ItemsGrid($$x("//div[@class='goods-tile']"));
        filterSidebar = new FiltersBlock($$x("//div[@class='sidebar-block']"));
    }

    private ItemTile getItemTile(int index) {
        return itemsGrid.getItemTiles().get(index);
    }

    // filter block element should be created
    // and this method should interact with it
    public ListItemsPage setPriceRange(int min, int max) {
        $x("//input[@formcontrolname='min'").sendKeys(Integer.toString(min));
        $x("//input[@formcontrolname='max'").sendKeys(Integer.toString(max));
        $x("//button[@class='slider-filter__button']").click();
        return this;
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

    public String getItemName(int index){
        return getItemTile(index).getItemLink().getText();
    }

    public ItemPage openItemsPage(int index){
         getItemTile(index).getItemLink().click();

         return new ItemPage();
    }

    public int getItemPrice(int index){
        String price = getItemTile(index).getItemPrice();

        return  Integer.parseInt(price);
    }

    public WishListPage addItemToWishList(int index){
        getItemTile(index).getAddToWishListButton().click();

        return new WishListPage();
    }

    public ListItemsPage  selectFilter(String filterTitle, String filterOptionTitle){
       filterSidebar.printAllFilters();
        filterSidebar.selectFilter(filterTitle,filterOptionTitle);
        return this;
    }



}
