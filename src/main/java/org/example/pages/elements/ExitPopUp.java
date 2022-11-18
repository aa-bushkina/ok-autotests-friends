package org.example.pages.elements;

import com.codeborne.selenide.Condition;
import org.example.pages.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class ExitPopUp
{
  public final String EXIT_BTN = ".//*[@id='hook_FormButton_logoff.confirm_not_decorate']";
  public final String CANCEL_BTN = ".//*[@id='hook_FormButton_logoff.cancel']";

  public LoginPage clickExitButton()
  {
    $x(EXIT_BTN).shouldBe(Condition.visible).click();
    return new LoginPage();
  }

  public void clickCancelButton()
  {
    $x(CANCEL_BTN).shouldBe(Condition.visible).click();
  }
}
