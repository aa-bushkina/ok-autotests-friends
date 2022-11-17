package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.pages.utils.FriendsStatus;
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

  private FriendsStatus friendsStatus;

  public UserPage()
  {
    recognizeFriendStatus();
  }

  public void recognizeFriendStatus()
  {
    if (ADD_FRIEND_BUTTON.getText().equals("Добавить в друзья"))
    {
      friendsStatus = FriendsStatus.NotFriend;
    } else if (ADD_FRIEND_BUTTON.getText().equals("Заявка отправлена"))
    {
      friendsStatus = FriendsStatus.Invited;
    } else if (ADD_FRIEND_BUTTON.getText().equals("Друзья"))
    {
      friendsStatus = FriendsStatus.Friend;
    }
  }

  public void addFriend()
  {
    if (friendsStatus.equals(FriendsStatus.NotFriend))
    {
      ADD_FRIEND_BUTTON.click();
    }
  }

  public NewsPage goToNewsPage()
  {
    OK_LOGO.click();
    return new NewsPage();
  }

}