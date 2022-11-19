package org.example.elements.otherFriendsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class OtherSubscribersBlock
{
  public final String SUBSCRIBERS_CARDS = ".//*[@class='ellip']";
  private final SelenideElement item;

  public OtherSubscribersBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public String findUser(final String name)
  {
    return item.$$x(SUBSCRIBERS_CARDS)
      .find(Condition.text(name)).getText();
  }
}
