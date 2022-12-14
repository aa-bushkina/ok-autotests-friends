package org.example.tests;

import com.codeborne.selenide.Selenide;
import org.example.pages.LoginPage;
import org.example.pages.utils.PageFactory;
import org.example.pages.utils.PageType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
public class AddSubscriberTest extends BaseTest {
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

  @DisplayName("При добавлении в друзья, у добавляемого пользователя появляется в подписчиках добавляющий пользователь")
  @Tag("development")
  @ParameterizedTest
  @ValueSource(strings = {NAME_OF_SEARCH_USER1, NAME_OF_SEARCH_USER2})
  public void addFriendShouldMakeNewSubscriber(final String name) {
    userPage = newsPage.findUser(name).addFriend();

    Selenide.refresh();
    otherFriendsPage = userPage.getNavigationBlock().clickFriends();

    otherFriendsPage.getOtherFriendSectionsBlock().clickSubscribers();
    assertAll(
      () -> assertThat(otherFriendsPage.getOtherFriendSectionsBlock().getCountSubscribers(), equalTo(1)),
      () -> assertThat(otherFriendsPage.getOtherSubscribersBlock().findUser(USERNAME + " " + USERNAME), equalTo(USERNAME + " " + USERNAME)));

    otherFriendsPage.getToolbar().goToNewsPage();
    newsPage.findUser(name).cancelInvite().getToolbar().goToNewsPage();
  }
}
