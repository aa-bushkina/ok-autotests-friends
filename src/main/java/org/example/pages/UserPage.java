package org.example.pages;

import org.example.pages.elements.toolbar.Toolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserPage extends LoadablePage
{
  private final String ADD_FRIEND_BTN = "//*[@data-l='outlandertarget,invite,t,invite']";
  private final String SEND_INVITE_BUTTON = "//*[@class='u-menu_a toggle-dropdown']";
  private final By OK_LOGO = byId("toolbar_logo_id");
  private final String CANCEL_INVITE_BTN = "//*[@data-l='outlandertarget,invite,t,invite']//*[@class='u-menu_a']";

  @Override
  public Toolbar getToolbar()
  {
    return super.getToolbar();
  }

  @Override
  protected void isLoaded() throws Error
  {

  }

  public UserPage addFriend()
  {
    $(byXpath(ADD_FRIEND_BTN)).click();
    $(byXpath(ADD_FRIEND_BTN)).shouldHave(text("Запрос отправлен"));
    return this;
  }

  public UserPage cancelInvite()
  {
    $x(SEND_INVITE_BUTTON).click();
    $x(CANCEL_INVITE_BTN).shouldBe(visible);
    $x(CANCEL_INVITE_BTN).click();
    $x(ADD_FRIEND_BTN).should(appear);
    $x(ADD_FRIEND_BTN).shouldHave(text("Добавить в друзья"));
    return this;
  }

  public String getFriendButtonText()
  {
    return $(byXpath(SEND_INVITE_BUTTON)).text();
  }


}