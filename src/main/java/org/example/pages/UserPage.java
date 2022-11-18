package org.example.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserPage extends LoadablePage
{
  private final String ADD_FRIEND_BUTTON = "//*[@data-l='outlandertarget,invite,t,invite']";
  private final String SEND_INVITE_BUTTON = "//*[@class='u-menu_a toggle-dropdown']";
  private final By OK_LOGO = byId("toolbar_logo_id");
  private final String CANCEL_INVITE_BUTTON = "//*[@data-l='outlandertarget,invite,t,invite']//*[@class='u-menu_a']";


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
    $x(SEND_INVITE_BUTTON).click();
    $x(CANCEL_INVITE_BUTTON).shouldBe(visible);
    $x(CANCEL_INVITE_BUTTON).click();
    $x(ADD_FRIEND_BUTTON).should(appear);
    $x(ADD_FRIEND_BUTTON).shouldHave(text("Добавить в друзья"));
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