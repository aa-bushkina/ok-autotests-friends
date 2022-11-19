package org.example.pages.elements.toolbar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.NewsPage;

public class Toolbar
{
  public final String ACTION_BTN = ".//*[@class='toolbar_dropdown_w h-mod']";
  public final String LOGO_BTN = ".//*[@id='toolbar_logo_id']";
  public final String SEARCH_FIELD = ".//*[@name='st.query']";
  private final SelenideElement item;

  public Toolbar(final SelenideElement item)
  {
    this.item = item;
  }

  public ActionsDropDownList clickActionButton()
  {
    item.$x(ACTION_BTN).shouldBe(Condition.visible).click();
    return new ActionsDropDownList(item);
  }

  public SearchDropDownList searchUser(final String str)
  {
    item.$x(SEARCH_FIELD).shouldBe(Condition.visible).setValue(str);
    return new SearchDropDownList(str, item);
  }

  public NewsPage goToNewsPage()
  {
    item.$x(LOGO_BTN).shouldBe(Condition.visible).click();
    return new NewsPage();
  }
}
