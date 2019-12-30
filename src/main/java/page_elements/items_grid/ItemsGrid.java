package page_elements.items_grid;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ItemsGrid {
    private List<ItemTile> itemTiles;

    public ItemsGrid(ElementsCollection collection) {
        System.out.println("This is what passed to the ItemsGrid constructor" + collection.size());

        itemTiles = new ArrayList<>();
        for (SelenideElement itemTile : collection) {
            ItemTile tile = new ItemTile();
            //if don't work replace with xpath
            tile.setItemPrice(itemTile.find(By.xpath(".//span[@class='goods-tile__price-value']")).getText());
            tile.setAddToComparisonButton(itemTile.find(By.xpath(".//button[@class='compare-button']")));
            tile.setAddToWishListButton(itemTile.find(By.xpath(".//button[@class='wish-button']")));
            tile.setAvailable(itemTile.getAttribute("class").contains("available"));
            tile.setItemLink(itemTile.find(By.xpath(".//span[@class='goods-tile__title']")));
            //tile.setRate(itemTile.find(By.xpath(".//div[@class='goods-tile__stars']/*svg")).getAttribute("aria-label"));
            tile.setReviewsLink(itemTile.find(By.xpath(".//span[@class='goods-tile__reviews-link']")));
            tile.setShoppingCartButton(itemTile.find(By.xpath(".//button[@class='goods-tile__buy-button']")));
            itemTiles.add(tile);
        }
    }
    public int getAmountOfItems(){
        return itemTiles.size();
    }
}
