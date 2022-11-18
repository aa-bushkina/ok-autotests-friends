package org.example.pages;

import org.example.pages.utils.FriendsStatus;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends LoadablePage
{
  @NotNull
  private final String ADD_FRIEND_BUTTON = "//*[@data-l='outlandertarget,invite,t,invite']";
  @NotNull
  private final String SEND_INVITE_BUTTON = "//*[@class='u-menu_a toggle-dropdown']";
  @NotNull
  private final By OK_LOGO = byId("toolbar_logo_id");
  @NotNull
  private final String CANCEL_INVITE_BUTTON = "//*[@class='dropdown_cnt u-menu_lvl2']//*[@class='u-menu_a']";


  @Override
  protected void isLoaded() throws Error
  {

  }

  public void addFriend()
  {
    $(byXpath(ADD_FRIEND_BUTTON)).click();
    $(byXpath(ADD_FRIEND_BUTTON)).shouldHave(text("Запрос отправлен"));
  }

  public void cancelInvite()
  {
    $(byXpath(SEND_INVITE_BUTTON)).click();
    $(byXpath(CANCEL_INVITE_BUTTON)).click();
    $(byXpath(ADD_FRIEND_BUTTON)).should(appear);
    $(byXpath(ADD_FRIEND_BUTTON)).shouldHave(text("Добавить в друзья"));
  }

  public String getFriendButtonText()
  {
    return $(byXpath(SEND_INVITE_BUTTON)).text();
  }

  public NewsPage goToNewsPage()
  {
    $(OK_LOGO).click();
    return new NewsPage();
  }

}