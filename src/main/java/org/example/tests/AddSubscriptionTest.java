package org.example.tests;

import org.example.pages.LoginPage;
import org.example.pages.utils.PageFactory;
import org.example.pages.utils.PageType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
public class AddSubscriptionTest extends BaseTest {
  final private String NAME_OF_SEARCH_USER1 = "technoPol4 technoPol4";
  final private String NAME_OF_SEARCH_USER2 = "technoPol22 technoPol22";

  @BeforeEach
  public void logIn() {
    loginPage = (LoginPage) PageFactory.createPage(PageType.Login);
    newsPage = loginPage.logIn(USERNAME, PSWD);
  }

  @AfterEach
  public void logOut() {
    newsPage.getToolbar().clickActionButton().clickExit().clickExitButton();
  }

  @DisplayName("При добавлении в друзья, у добавляющего пользователя появляется в подписках добавлямеый пользователь")
  @Tag("production")
  @ParameterizedTest
  @ValueSource(strings = {NAME_OF_SEARCH_USER1, NAME_OF_SEARCH_USER2})
  public void addFriendShouldMakeNewSubscription(final String name) {
    friendsPage = newsPage.goToFriends();
    assertThat(friendsPage.getFriendSectionsBlock().isOutgoingRequestsExist(), is(false));
    newsPage = friendsPage.getToolbar().goToNewsPage();

    newsPage.findUser(name).addFriend().getToolbar().goToNewsPage();

    friendsPage = newsPage.goToFriends();

    friendsPage.getFriendSectionsBlock().clickOutgoingRequests();
    assertAll(
      () -> assertThat(friendsPage.getFriendSectionsBlock().getCountOutgoingRequests(), equalTo(1)),
      () -> assertThat(friendsPage.getRequestsBlock().findRequestToUser(name), equalTo(name)));

    newsPage.findUser(name).cancelInvite().getToolbar().goToNewsPage();
  }
}
