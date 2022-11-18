package org.example.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.UserPage;
import org.jetbrains.annotations.NotNull;

public class SearchDropDownList
{
  private final String USER_CARD =
    ".//div[contains(@class, 'card-caption__a0i64 card-caption-small__02cy5') and " +
      "text() = 'technoPol4 technoPol4']";
  private final SelenideElement item;

  public SearchDropDownList(@NotNull final SelenideElement item)
  {
    this.item = item;
  }

  public UserPage goToUserPage()
  {
    item.hover().$x(USER_CARD).shouldBe(Condition.visible).click();
    return new UserPage();
  }
}
