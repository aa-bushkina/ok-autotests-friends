package org.example.elements.toolbar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.UserPage;


public class SearchDropDownList
{
  private final String USER_CARDS = ".//div[contains(@class, 'card-caption__a0i64 card-caption-small__02cy5')]";
  private final String name;
  private final SelenideElement item;

  public SearchDropDownList(String str, final SelenideElement item)
  {
    this.name = str;
    this.item = item;
  }

  public UserPage goToUserPage()
  {
    item.$$x(USER_CARDS)
      .find(Condition.text(name))
      .shouldBe(Condition.visible)
      .click();
    return new UserPage();
  }
}
