package page_elements.items_grid;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import page_objects.ItemPage;
import page_objects.ReviewsPage;

@Getter
@Setter
public class ItemTile {
    private SelenideElement itemLink;
    private String itemPrice;
    private String rate;
    private boolean isAvailable;
    private SelenideElement shoppingCartButton;
    private SelenideElement addToWishListButton;
    private SelenideElement addToComparisonButton;
    private SelenideElement reviewsLink;


}
