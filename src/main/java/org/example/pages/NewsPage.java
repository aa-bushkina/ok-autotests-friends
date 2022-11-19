package org.example.pages;

import org.example.pages.elements.newsSections.NavigationBlock;

import static com.codeborne.selenide.Selenide.$x;

public class NewsPage extends LoadablePage
{
  private final String FRIENDS_SECTION = "//a[@data-l='t,userFriend']";
  private final String NAVIGATION_BLOCK = "//*[@class='navigation']";
  final private NavigationBlock navigationBlock;

  public NewsPage()
  {
    this.navigationBlock = new NavigationBlock($x(NAVIGATION_BLOCK));
  }

  public UserPage findUser(final String name)
  {
    return toolbar.searchUser(name).goToUserPage();
  }

  public LoginPage exit()
  {
    return toolbar.clickActionButton()
      .clickExit()
      .clickExitButton();
  }

  public FriendsPage goToFriends()
  {
    return navigationBlock.clickFriends();
  }

  @Override
  protected void isLoaded() throws Error
  {

  }
}
