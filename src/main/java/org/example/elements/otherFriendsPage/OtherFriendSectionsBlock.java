package org.example.elements.otherFriendsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OtherFriendSectionsBlock
{
  public final String SUBSCRIBERS_SECTIONS = ".//*[@data-l='t,friendSubscribers']";
  private final String SUBSCRIBERS_COUNT = ".//*[@data-l='t,friendSubscribers']//*[@class='navMenuCount']";
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
    $x(SUBSCRIBERS_SECTIONS)
      .click();
    return this;
  }
}
