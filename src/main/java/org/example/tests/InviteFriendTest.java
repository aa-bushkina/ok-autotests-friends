package org.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
public class InviteFriendTest extends BaseTest
{
  final private String NAME_OF_SEARCH_USER1 = "technoPol4 technoPol4";
  final private String NAME_OF_SEARCH_USER2 = "technoPol22 technoPol22";

  @DisplayName("При добавлении в друзья, у добавляющего пользователя появляется в подписках добавлямеый пользователь")
  @Tag("development")
  @ParameterizedTest
  @ValueSource(strings = {NAME_OF_SEARCH_USER1, NAME_OF_SEARCH_USER2})
  public void addFriendShouldMakeNewSubscription(final String name)
  {
    newsPage.findUser(name).addFriend().getToolbar().goToNewsPage();

    friendsPage = newsPage.goToFriends();

    friendsPage.getFriendSectionsBlock().clickOutgoingRequests();
    assertAll(
      () -> assertThat(friendsPage.getCountOutgoingRequests(), equalTo(1)),
      () -> assertThat(friendsPage.getRequestsBlock().findRequestToUser(name), equalTo(name)));

    newsPage.findUser(name).cancelInvite().getToolbar().goToNewsPage();
  }

/*  @Test
  @DisplayName("При добавлении в друзья, у добавляемого пользователя появляется в подписчиках добавляющий пользователь")
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
