package org.example.elements.friendPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class RequestsBlock
{
  public final String REQUEST_CARDS = ".//*[@class='ucard-w_t']";
  private final SelenideElement item;

  public RequestsBlock(final SelenideElement item)
  {
    this.item = item;
  }

  public String findRequestToUser(final String name)
  {
    return item.$$x(REQUEST_CARDS)
      .find(Condition.text(name)).getText();
  }
}
