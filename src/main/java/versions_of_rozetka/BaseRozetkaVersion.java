package versions_of_rozetka;

import com.codeborne.selenide.ElementsCollection;

public abstract class BaseRozetkaVersion {
    public abstract boolean isPresentInItemTitle(ElementsCollection elements, String searchedName);
}
