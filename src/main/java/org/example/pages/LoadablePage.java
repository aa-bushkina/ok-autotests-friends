package org.example.pages;

import org.example.pages.elements.Toolbar;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;

public abstract class LoadablePage extends LoadableComponent<FriendsPage>
{
  protected String TOOLBAR = "//*[@class='toolbar_c']";

  protected Toolbar toolbar = new Toolbar($(By.xpath(TOOLBAR)));

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
