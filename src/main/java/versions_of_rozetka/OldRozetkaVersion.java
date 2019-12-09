package versions_of_rozetka;

import com.codeborne.selenide.ElementsCollection;

public class OldRozetkaVersion extends BaseRozetkaVersion {

    @Override
    public boolean isPresentInItemTitle(ElementsCollection elements, String searchedName) {
        boolean isSearchedNameIsPresentInItemTitle = false;
        int indexOfTheLastItemThatShouldBeVerifed = 3;
        if (elements.size() >= 4) {
            for (int i = 0; i <= indexOfTheLastItemThatShouldBeVerifed; i++) {
                String titleOfTheItem = elements.get(indexOfTheLastItemThatShouldBeVerifed).
                        find("app-goods-tile-default > div > div.goods-tile__inner > " +
                                "a.goods-tile__heading > span").getText()
                        .toLowerCase().replaceAll("[«,»]","");

                if (titleOfTheItem.contains(searchedName)) {
                    isSearchedNameIsPresentInItemTitle = true;
                } else {
                    System.out.println(titleOfTheItem);
                    break;
                }
            }
        } else {
            for (int i = 0; i < elements.size(); i++) {
                String titleOfTheItem = elements.get(i).
                        find("app-goods-tile-default > div > div.goods-tile__inner > " +
                                "a.goods-tile__heading > span").getText()
                        .toLowerCase().replaceAll("[«,»]","");;

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
