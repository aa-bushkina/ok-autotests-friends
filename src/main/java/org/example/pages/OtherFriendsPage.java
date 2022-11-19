package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.pages.elements.toolbar.Toolbar;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$x;

public class OtherFriendsPage extends LoadablePage
{
/*
  @NotNull
  private final By FRIEND_SECTION = By.xpath("nav-side_i-w");
  @NotNull
  private final By SUBSCRIPTIONS_SECTION = By.className("nav-side_tx ellip");
*/

  @Override
  public Toolbar getToolbar()
  {
    return super.getToolbar();
  }
  @Override
  protected void isLoaded() throws Error
  {
    // $x(NAVIGATION_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок навигации по странице"));

  }

  public void goToOutgoingFriendsRequests()
  {
  }
}
