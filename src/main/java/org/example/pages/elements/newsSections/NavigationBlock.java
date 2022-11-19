package org.example.pages.elements.newsSections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.FriendsPage;

public class NavigationBlock
{
  public final String NAVIGATION_SECTIONS = ".//*[@class='nav-side_i-w']";
  private final SelenideElement item;

  public NavigationBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public FriendsPage clickFriends()
  {
    item.$$x(NAVIGATION_SECTIONS)
      .find(Condition.text("Друзья"))
      .shouldBe(Condition.visible)
      .click();
    return new FriendsPage();
  }

}
