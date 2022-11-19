package org.example.pages;

import org.example.pages.elements.toolbar.Toolbar;

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
