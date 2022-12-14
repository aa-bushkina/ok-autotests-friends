package org.example.pages;

import org.example.elements.toolbar.Toolbar;

import static com.codeborne.selenide.Selenide.$x;

public interface WithToolbarPage {
  String TOOLBAR = "//*[@class='toolbar_c']";
  Toolbar toolbar = new Toolbar($x(TOOLBAR));

  default Toolbar getToolbar() {
    return toolbar;
  }
}
