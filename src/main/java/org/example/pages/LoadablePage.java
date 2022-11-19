package org.example.pages;

import org.example.elements.toolbar.Toolbar;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$x;

public abstract class LoadablePage extends LoadableComponent<FriendsPage>
{
  protected String TOOLBAR = "//*[@class='toolbar_c']";

  protected Toolbar toolbar = new Toolbar($x(TOOLBAR));

  public Toolbar getToolbar()
  {
    return toolbar;
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
