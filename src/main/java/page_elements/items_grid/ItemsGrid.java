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
    private List<ItemTile> itemTiles = new ArrayList<>();

    public ItemsGrid(ElementsCollection collection) {
        collection.stream()
                .forEach(itemTileElement -> {
                    ItemTile tile = new ItemTile();
                    itemTileElement.shouldBe(Condition.enabled);
                    tile.setItemPrice(itemTileElement.find(By.xpath(".//span[@class='goods-tile__price-value']")).getText());
                    tile.setAddToComparisonButton(itemTileElement.find(By.xpath(".//button[@class='compare-button']")));
                    tile.setAddToWishListButton(itemTileElement.find(By.xpath(".//button[@class='wish-button']")));
                    tile.setAvailable(itemTileElement.find(By.cssSelector("div.goods-tile__availability")).getAttribute("class").contains("available"));
                    tile.setItemLink(itemTileElement.find(By.xpath(".//span[@class='goods-tile__title']")));
                    if (itemTileElement.find(By.xpath(".//div[@class='goods-tile__stars']")).exists()) {
                        tile.setRate(itemTileElement.find(By.xpath(".//div[@class='goods-tile__stars']")).find(By.cssSelector("svg")).getAttribute("aria-label"));
                    }
                    tile.setReviewsLink(itemTileElement.find(By.xpath(".//span[@class='goods-tile__reviews-link']")));
                    tile.setShoppingCartButton(itemTileElement.find(By.xpath(".//button[@class='goods-tile__buy-button']")));
                    itemTiles.add(tile);
                });
    }
}
