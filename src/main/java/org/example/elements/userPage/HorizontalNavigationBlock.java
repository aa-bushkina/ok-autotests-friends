package org.example.elements.userPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.OtherFriendsPage;

public class HorizontalNavigationBlock
{
  public final String FRIENDS_SECTION = ".//*[@data-l='outlandermenu,friendFriend']";
  private final SelenideElement item;

  public HorizontalNavigationBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public OtherFriendsPage clickFriends()
  {
    item.$x(FRIENDS_SECTION).shouldBe(Condition.visible).click();
    return new OtherFriendsPage();
  }
}
