package org.example.elements.otherFriendsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OtherFriendSectionsBlock
{
  public final String FRIENDS_SECTIONS = ".//*[@class='nav-side_i-w']";
  private final String SUBSCRIBERS_COUNT = "//*[@class='lstp-t']";
  private final SelenideElement item;

  public OtherFriendSectionsBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public int getCountSubscribers()
  {
    return Integer.parseInt($x(SUBSCRIBERS_COUNT).text());
  }

  public OtherFriendSectionsBlock clickSubscribers()
  {
    item.$$x(FRIENDS_SECTIONS)
      .find(Condition.text("Подписчики"))
      .shouldBe(Condition.visible)
      .click();
    return this;
  }
}
