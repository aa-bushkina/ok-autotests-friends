package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;

public class FriendsPage extends LoadableComponent<FriendsPage>
{
/*
  @NotNull
  private final By FRIEND_SECTION = By.xpath("nav-side_i-w");
  @NotNull
  private final By SUBSCRIPTIONS_SECTION = By.className("nav-side_tx ellip");
*/

  @Override
  protected void load()
  {

  }

  @Override
  protected void isLoaded() throws Error
  {

  }

  public void goToOutgoingFriendsRequests()
  {
  }
}
