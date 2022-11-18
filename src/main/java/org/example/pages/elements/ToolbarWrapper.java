package org.example.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.NewsPage;

public class ToolbarWrapper
{
  public final String ACTION_BTN = ".//*[@class='toolbar_dropdown_w h-mod']";
  public final String LOGO_BTN = "//*[]";
  private final SelenideElement item;

  public ToolbarWrapper(final SelenideElement item)
  {
    this.item = item;
  }

  public ActionsDropDownListWrapper clickActionButton()
  {
    item.$x(ACTION_BTN).shouldBe(Condition.visible).click();
    return new ActionsDropDownListWrapper(item);
  }

  public void clickSearchField()
  {

  }

  public NewsPage clickLogo()
  {
    return new NewsPage();
  }
}
