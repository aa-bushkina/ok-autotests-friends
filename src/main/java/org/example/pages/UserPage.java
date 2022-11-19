package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.pages.elements.toolbar.Toolbar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserPage extends LoadablePage
{
  private final String ADD_FRIEND_BTN = "//*[@data-l='outlandertarget,invite,t,invite']";
  private final String SEND_INVITE_BUTTON = "//*[@class='u-menu_a toggle-dropdown']";
  private final String CANCEL_INVITE_BTN = "//*[@data-l='outlandertarget,invite,t,invite']//*[@class='u-menu_a']";

  @Override
  public Toolbar getToolbar()
  {
    return super.getToolbar();
  }

  @Override
  protected void isLoaded() throws Error
  {
    $x(ADD_FRIEND_BTN).shouldBe(Condition.visible.because("Не отобразилась кнопка добавления в друзья"));
    $x(SEND_INVITE_BUTTON).shouldBe(appear.because("Не существует кнопка отмены заявки в друзья"));
    $x(CANCEL_INVITE_BTN).shouldBe(appear.because("Не существует кнопка отмененной заявки в друзья"));
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