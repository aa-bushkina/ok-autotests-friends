package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class FriendsPage
{
  @NotNull
  private final ElementsCollection FRIEND_SECTIONS = $$(By.className("nav-side_i-w"));
  @NotNull
  private final ElementsCollection SUBSCRIPTIONS_SECTIONS = $$(By.className("nav-side_tx ellip"));

/*
  public void goToOutgoingFriendsRequests()
  {
    Stream stream = FRIEND_SECTIONS.stream();
    SelenideElement outgoingFriendsSection = FRIEND_SECTIONS.stream().anyMatch(section -> section.getText().equals("Подписки"));
  }*/
}
