package org.example.pages.elements.toolbar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ActionsDropDownList
{
  public final String exitButtonLoc = ".//*[@class='lp']";
  private final SelenideElement item;

  public ActionsDropDownList(final SelenideElement item)
  {
    this.item = item;
  }

  public ExitPopUp clickExit()
  {
    item.hover().$x(exitButtonLoc).shouldBe(Condition.visible).click();
    return new ExitPopUp();
  }
}
