package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage
{

  @NotNull
  private final SelenideElement SEARCH_FIELD = $(byName("st.query"));
  @NotNull
  private final SelenideElement USER =
    $(byXpath("//div[contains(@class, 'card-caption__a0i64 card-caption-small__02cy5') and " +
      "text() = 'technoPol4 technoPol4']"));

  private final SelenideElement FRIENDS_SECTION = $(byXpath("//div[@data-l='t,userFriend']"));

  public UserPage findUser(@NotNull final String name)
  {
    SEARCH_FIELD.setValue(name);
    USER.click();
    return new UserPage();
  }

  public FriendsPage goToFriends()
  {
    FRIENDS_SECTION.click();
    return new FriendsPage();
  }
}
