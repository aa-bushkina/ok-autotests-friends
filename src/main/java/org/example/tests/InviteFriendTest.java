package org.example.tests;

import org.example.pages.FriendsPage;
import org.example.pages.LoginPage;
import org.example.pages.NewsPage;
import org.example.pages.UserPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

@Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
public class InviteFriendTest extends BaseTest
{
  final private String USERNAME = "technoPol5";
  final private String PSWD = "technoPolis2022";
  final private String NAME_OF_SEARCH_USER1 = "technoPol4 technoPol4";
  final private String NAME_OF_SEARCH_USER2 = "technoPol22 technoPol22";

  protected LoginPage loginPage;
  protected NewsPage newsPage;
  protected UserPage userPage;
  protected FriendsPage friendsPage;

  @BeforeEach
  public void logIn()
  {
    loginPage = new LoginPage();
    newsPage = loginPage.logIn(USERNAME, PSWD);
  }

  @AfterEach
  public void deleteFriendInviteAndExit()
  {
    newsPage.getToolbar()
      .clickActionButton()
      .clickExit()
      .clickExitButton();
  }

  @DisplayName("При добавлении в друзья, у добавляемого пользователя появляется в подписчиках добавляющий пользователь")
  @Tag("development")
  @ParameterizedTest
  @ValueSource(strings = {NAME_OF_SEARCH_USER1, NAME_OF_SEARCH_USER2})
  public void addFriendShouldMakeNewSubscription(final String name)
  {
    newsPage.findUser(name)
      .addFriend()
      .goToNewsPage();
    newsPage.goToFriends()
      .goToOutgoingFriendsRequests();

    newsPage.findUser(name).cancelInvite().goToNewsPage();
  }

/*  @Test
  @DisplayName("При добавлении в друзья, у добавляющего пользователя появляется в подписках добавлямеый пользователь")
  @Tag("development")
  public void addFriendShouldMakeNewSubscriber()
  {
    userPage = newsPage.findUser(NAME_OF_SEARCH_USER);
    userPage.addFriend();
  }

  @Test
  @DisplayName("При добавлении в друзья выводится список возможных друзей")
  @Tag("development")
  public void addFriendShouldMakeSuggestPossibleFriends()
  {
    userPage = newsPage.findUser(NAME_OF_SEARCH_USER);
    userPage.addFriend();
  }*/
}
