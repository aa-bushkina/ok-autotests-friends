package org.example.pages;

import org.example.pages.utils.FriendsStatus;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends LoadableComponent<UserPage>
{
  @NotNull
  private final By ADD_FRIEND_BUTTON = byXpath("//div[@data-l='outlandertarget,invite,t,invite']");
  @NotNull
  private final By OK_LOGO = byId("toolbar_logo_id");
  @NotNull
  private final By CANCEL_INVITE_BUTTON = byClassName("u-menu_a");


  private FriendsStatus friendsStatus;

  public UserPage()
  {
    recognizeFriendStatus();
  }

  @Override
  protected void load()
  {
  }

  @Override
  protected void isLoaded() throws Error
  {

  }

  public void recognizeFriendStatus()
  {
    if ($(ADD_FRIEND_BUTTON).getText().equals("Добавить в друзья"))
    {
      friendsStatus = FriendsStatus.NotFriend;
    } else if ($(ADD_FRIEND_BUTTON).getText().equals("Заявка отправлена"))
    {
      friendsStatus = FriendsStatus.Invited;
    } else if ($(ADD_FRIEND_BUTTON).getText().equals("Друзья"))
    {
      friendsStatus = FriendsStatus.Friend;
    }
  }

  public void addFriend()
  {
    if (friendsStatus.equals(FriendsStatus.NotFriend))
    {
      $(ADD_FRIEND_BUTTON).click();
      friendsStatus = FriendsStatus.Invited;
    }
  }

  public void cancelInvite()
  {
    if (friendsStatus.equals(FriendsStatus.Invited))
    {
      $(ADD_FRIEND_BUTTON).click();
      $(CANCEL_INVITE_BUTTON).click();
    }
  }

  public String getFriendButtonText()
  {
    return $(ADD_FRIEND_BUTTON).text();
  }

  public NewsPage goToNewsPage()
  {
    $(OK_LOGO).click();
    return new NewsPage();
  }

}