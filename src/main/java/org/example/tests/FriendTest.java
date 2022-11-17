package org.example.tests;

import org.example.pages.FriendsPage;
import org.example.pages.LoginPage;
import org.example.pages.NewsPage;
import org.example.pages.UserPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FriendTest extends BaseTest
{
  final private String USERNAME = "technoPol5";
  final private String PSWD = "technoPolis2022";
  final private String NAME_OF_SEARCH_USER = "technoPol17";

  private LoginPage loginPage;
  private NewsPage newsPage;
  private UserPage userPage;
  private FriendsPage friendsPage;

  @Test
  public void addFriendShouldMakeNewSubscription()
  {
    loginPage = new LoginPage();
    newsPage = loginPage.logIn(USERNAME, PSWD);
    userPage = newsPage.findUser(NAME_OF_SEARCH_USER);
    userPage.addFriend();
    assertThat(userPage.getFriendButtonText(), equalTo("Заявка отправлена"));
    newsPage = userPage.goToNewsPage();
    friendsPage = newsPage.goToFriends();
  }
}
