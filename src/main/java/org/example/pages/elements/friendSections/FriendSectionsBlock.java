package org.example.pages.elements.friendSections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FriendSectionsBlock
{
  public final String FRIENDS_SECTIONS = ".//*[@class='nav-side_i-w']";
  private final String OUTGOING_REQUESTS_COUNT = "//*[@id='counter_outgoingFriendRequestsPage']";
  private final SelenideElement item;

  public FriendSectionsBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public int getCountOutgoingRequests()
  {
    return Integer.parseInt($x(OUTGOING_REQUESTS_COUNT).text());
  }

  public FriendSectionsBlock clickOutgoingRequests()
  {
    item.$$x(FRIENDS_SECTIONS)
      .find(Condition.text("Исходящие заявки в друзья"))
      .shouldBe(Condition.visible)
      .click();
    return this;
  }
}
