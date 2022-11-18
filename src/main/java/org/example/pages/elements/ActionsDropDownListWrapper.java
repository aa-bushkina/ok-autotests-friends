package org.example.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;

public class ActionsDropDownListWrapper
{
  public final String exitButtonLoc = ".//*[@class='lp']";
  private final SelenideElement item;

  public ActionsDropDownListWrapper(final SelenideElement item)
  {
    this.item = item;
  }

  public ExitPopUp clickExit()
  {
    item.hover().$x(exitButtonLoc).shouldBe(Condition.visible).click();
    return new ExitPopUp();
  }
}
