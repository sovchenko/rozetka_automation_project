package versions_of_rozetka;

import com.codeborne.selenide.ElementsCollection;

public class NewRozetkaVersion extends BaseRozetkaVersion {
    @Override
    public boolean isPresentInItemTitle(ElementsCollection elements, String searchedName) {
        boolean isSearchedNameIsPresentInItemTitle = false;
        int indexOfTheLastItemThatShouldBeVerifed = 3;
        if (elements.size() >= 4) {
            for (int i = 0; i <= indexOfTheLastItemThatShouldBeVerifed; i++) {
                String titleOfTheItem = elements.get(indexOfTheLastItemThatShouldBeVerifed).
                        find("div > div > div > div > div.g-i-tile-i-title.clearfix > a").getText()
                        .toLowerCase();

                if (titleOfTheItem.contains(searchedName)) {
                    isSearchedNameIsPresentInItemTitle = true;
                } else {
                    System.out.println(titleOfTheItem);
                    break;
                }
            }
        } else {
            for (int i = 0; i < elements.size(); i++) {
                String titleOfTheItem = elements.get(indexOfTheLastItemThatShouldBeVerifed).
                        find("div > div > div > div > div.g-i-tile-i-title.clearfix > a").getText()
                        .toLowerCase();

                if (titleOfTheItem.contains(searchedName)) {
                    isSearchedNameIsPresentInItemTitle = true;
                } else {
                    System.out.println(titleOfTheItem);
                    break;
                }
            }
        }
        return isSearchedNameIsPresentInItemTitle;
    }
}