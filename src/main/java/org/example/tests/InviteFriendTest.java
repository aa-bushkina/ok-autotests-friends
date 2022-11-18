package org.example.tests;

import org.example.pages.FriendsPage;
import org.example.pages.LoginPage;
import org.example.pages.NewsPage;
import org.example.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InviteFriendTest extends BaseTest
{
  final private String USERNAME = "technoPol5";
  final private String PSWD = "technoPolis2022";
  final private String NAME_OF_SEARCH_USER = "technoPol4";

  protected LoginPage loginPage;
  protected NewsPage newsPage;
  protected UserPage userPage;
  protected FriendsPage friendsPage;

  @BeforeEach
  public void logInAndAddFriend()
  {
    loginPage = new LoginPage();
    newsPage = loginPage.logIn(USERNAME, PSWD);
    userPage = newsPage.findUser(NAME_OF_SEARCH_USER);
    userPage.addFriend();
  }

  @AfterEach
  public void deleteFriendInvite()
  {
    userPage = newsPage.findUser(NAME_OF_SEARCH_USER);
    userPage.cancelInvite();
  }
  @Test
  public void addFriendShouldMakeNewSubscription()
  {
    newsPage = new NewsPage();
    friendsPage = newsPage.goToFriends();
  }
}
