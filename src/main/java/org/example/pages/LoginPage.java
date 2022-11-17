package org.example.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadableComponent<LoginPage>
{
  @NotNull
  private final By USERNAME_FIELD = byName("st.email");
  @NotNull
  private final By PSWD_FIELD = byName("st.password");
  @NotNull
  private final By SIGNIN_BUTTON = byClassName("button-pro __wide");

  public NewsPage logIn(@NotNull final String username, @NotNull final String password)
  {
    $(USERNAME_FIELD).val(username);
    $(PSWD_FIELD).val(password);
    $(SIGNIN_BUTTON).click();
    return new NewsPage();
  }

  @Override
  protected void load()
  {

  }

  @Override
  protected void isLoaded() throws Error
  {

  }
}
