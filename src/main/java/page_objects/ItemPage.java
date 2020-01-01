package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ItemPage {
    private SelenideElement reviewLinks = $x("//a[@class='product__rating-reviews']");

    public int getItemPrice() {
        //used regex which replaces all non-digit characters with empty string
        return Integer.parseInt($x("//p[@class='product-prices__big']").getText().replaceAll("\\D", ""));
    }

    public String getItemTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public String getItemRate() {
        return $x("//app-rating-stars").find(By.cssSelector("svg")).getAttribute("aria-label");
    }

    public int getAmountOfReviews() {
        return Integer.parseInt(reviewLinks.getText().replaceAll("\\D", ""));
    }

    public ItemPage openReviewsTab() {
        reviewLinks.click();
        return this;
    }

    public String getHeaderOfReviewsSection() {
        SelenideElement titleOfReviewSection = $x("//div[@class='product-comments__header']/h2[@class='product-tabs__heading']").shouldBe(Condition.visible);
        return titleOfReviewSection.getText();
    }
}
