package org.example.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

public class ActionsDropDownList
{
  public final String exitButtonLoc = ".//*[@class='lp']";
  private final SelenideElement item;

  public ActionsDropDownList(@NotNull final SelenideElement item)
  {
    this.item = item;
  }

  public ExitPopUp clickExit()
  {
    item.hover().$x(exitButtonLoc).shouldBe(Condition.visible).click();
    return new ExitPopUp();
  }
}
