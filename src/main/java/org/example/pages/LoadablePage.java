package org.example.pages;

import org.example.pages.elements.ToolbarWrapper;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;

public abstract class LoadablePage extends LoadableComponent<FriendsPage>
{
  @NotNull
  protected String TOOLBAR = "//*[@class='toolbar_c']";
  @NotNull
  public ToolbarWrapper toolbar = new ToolbarWrapper($(By.xpath(TOOLBAR)));

  @Override
  protected void load()
  {

  }

  @Override
  protected void isLoaded() throws Error
  {

  }
}
