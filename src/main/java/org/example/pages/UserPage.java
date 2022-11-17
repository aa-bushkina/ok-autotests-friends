package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserPage
{

  @NotNull
  private final SelenideElement ADD_FRIEND_BUTTON = $(byXpath("//div[@data-l='outlandertarget,invite,t,invite']"));
  @NotNull
  private final SelenideElement OK_LOGO = $(byId("toolbar_logo_id"));

  public boolean isInviteInFriends()
  {
    if (ADD_FRIEND_BUTTON.getText().equals("Добавить в друзья"))
    {
      return false;
    } else return ADD_FRIEND_BUTTON.getText().equals("Заявка отправлена") ||
      ADD_FRIEND_BUTTON.getText().equals("Друзья");
  }

  public void addFriend(@NotNull final String name)
  {
    if (!isInviteInFriends())
    {
      ADD_FRIEND_BUTTON.click();
    }
  }

  public NewsPage goToNewsPage(@NotNull final String name)
  {
    OK_LOGO.click();
    return new NewsPage();
  }

}