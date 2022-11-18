package org.example.pages;

public class NewsPage extends LoadablePage
{
  private final String FRIENDS_SECTION = "//a[@data-l='t,userFriend']";

  public UserPage findUser(final String name)
  {
    return toolbar.searchUser(name).goToUserPage();
  }

  public FriendsPage goToFriends()
  {
    //$(By.xpath(FRIENDS_SECTION)).click();
    return new FriendsPage();
  }

  @Override
  protected void isLoaded() throws Error
  {

  }
}
