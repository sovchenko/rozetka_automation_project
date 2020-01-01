package page_elements.items_grid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ItemsGrid {
    private List<ItemTile> itemTiles;

    public ItemsGrid(ElementsCollection collection) {
        itemTiles = new ArrayList<>();
        for (SelenideElement itemTile : collection) {
            itemTile.shouldBe(Condition.enabled);
            ItemTile tile = new ItemTile();
            tile.setItemPrice(itemTile.find(By.xpath(".//span[@class='goods-tile__price-value']")).getText());
            tile.setAddToComparisonButton(itemTile.find(By.xpath(".//button[@class='compare-button']")));
            tile.setAddToWishListButton(itemTile.find(By.xpath(".//button[@class='wish-button']")));
            tile.setAvailable(itemTile.find(By.cssSelector("div.goods-tile__availability")).getAttribute("class").contains("available"));
            tile.setItemLink(itemTile.find(By.xpath(".//span[@class='goods-tile__title']")));
            if (itemTile.find(By.xpath(".//div[@class='goods-tile__stars']")).exists()) {
                tile.setRate(itemTile.find(By.xpath(".//div[@class='goods-tile__stars']")).find(By.cssSelector("svg")).getAttribute("aria-label"));
            }
            tile.setReviewsLink(itemTile.find(By.xpath(".//span[@class='goods-tile__reviews-link']")));
            tile.setShoppingCartButton(itemTile.find(By.xpath(".//button[@class='goods-tile__buy-button']")));
            itemTiles.add(tile);
        }

    }
}
