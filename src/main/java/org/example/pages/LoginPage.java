package org.example.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends LoadablePage implements WithToolbarPage {
  private final String USERNAME_FIELD = "//input[@name='st.email']";
  private final String PSWD_FIELD = "//input[@name='st.password']";
  private final String SIGNIN_BUTTON = "//input[@data-l='t,sign_in']";

  public NewsPage logIn(final String username, final String password) {
    $x(USERNAME_FIELD).sendKeys(username);
    $x(PSWD_FIELD).sendKeys(password);
    $x(SIGNIN_BUTTON).click();
    return new NewsPage();
  }

  @Override
  protected void isLoaded() throws Error {
    $x(USERNAME_FIELD).shouldBe(Condition.visible.because("Не отобразилось поле ввода логина"));
    $x(PSWD_FIELD).shouldBe(Condition.visible.because("Не отобразилось поле ввода пароля"));
    $x(SIGNIN_BUTTON).shouldBe(Condition.visible.because("Не отобразилась кнопка входа"));
  }
}
