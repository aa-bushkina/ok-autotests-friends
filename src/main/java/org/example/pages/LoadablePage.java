package org.example.pages;

import org.openqa.selenium.support.ui.LoadableComponent;

@SuppressWarnings("rawtypes")
public abstract class LoadablePage extends LoadableComponent {
  @Override
  protected void load() {
  }

  @Override
  protected void isLoaded() throws Error {
  }
}
