package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.elements.newsPage.NavigationBlock;

import static com.codeborne.selenide.Selenide.$x;

public class NewsPage extends LoadablePage implements WithToolbarPage {
  private final String NAVIGATION_BLOCK = "//*[@class='navigation']";
  final private NavigationBlock navigationBlock;

  public NewsPage() {
    this.navigationBlock = new NavigationBlock($x(NAVIGATION_BLOCK));
  }

  public UserPage findUser(final String name) {
    return toolbar.searchUser(name).goToUserPage();
  }

  public FriendsPage goToFriends() {
    return navigationBlock.clickFriends();
  }

  @Override
  protected void isLoaded() throws Error {
    $x(NAVIGATION_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок навигации по странице"));
  }
}
