package org.example.pages;

import org.example.pages.elements.toolbar.Toolbar;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends LoadablePage
{
  private final String USERNAME_FIELD = "//input[@name='st.email']";
  private final String PSWD_FIELD = "//input[@name='st.password']";
  private final String SIGNIN_BUTTON = "//input[@data-l='t,sign_in']";

  public NewsPage logIn(final String username, final String password)
  {
    $x(USERNAME_FIELD).sendKeys(username);
    $x(PSWD_FIELD).sendKeys(password);
    $x(SIGNIN_BUTTON).click();
    return new NewsPage();
  }
  @Override
  public Toolbar getToolbar()
  {
    return super.getToolbar();
  }
  @Override
  protected void isLoaded() throws Error
  {

  }
}
