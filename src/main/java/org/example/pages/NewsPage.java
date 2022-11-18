package org.example.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends LoadablePage
{
  private final By SEARCH_FIELD = byName("st.query");
  private final By USER =
    byXpath("//div[contains(@class, 'card-caption__a0i64 card-caption-small__02cy5') and " +
      "text() = 'technoPol4 technoPol4']");

  private final String FRIENDS_SECTION = "//a[@data-l='t,userFriend']";

  public UserPage findUser(@NotNull final String name)
  {
    $(SEARCH_FIELD).setValue(name);
    $(USER).click();
    return new UserPage();
  }

  public FriendsPage goToFriends()
  {
    //$(By.xpath(FRIENDS_SECTION)).click();
    return new FriendsPage();
  }

  @Override
  protected void isLoaded() throws Error
  {

  }
}
