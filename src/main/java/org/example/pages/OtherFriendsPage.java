package org.example.pages;

import org.example.pages.elements.toolbar.Toolbar;
import org.openqa.selenium.support.ui.LoadableComponent;

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

  }

  public void goToOutgoingFriendsRequests()
  {
  }
}
