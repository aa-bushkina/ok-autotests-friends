package org.example.pages;

import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage
{
  @NotNull
  private final String USERNAME_FIELD = "//*[@name='st.email']";
  @NotNull
  private final String PSWD_FIELD = "//*[@name='st.password']";
  @NotNull
  private final String SIGNIN_BUTTON = "//*[@class='button-pro __wide']";

  public void logIn(@NotNull final String username, @NotNull final String password)
  {
    $(byXpath(USERNAME_FIELD)).val(username);
    $(byXpath(PSWD_FIELD)).val(password);
    $(byXpath(SIGNIN_BUTTON)).click();
  }
}
