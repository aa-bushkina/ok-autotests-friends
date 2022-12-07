package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.elements.friendPage.FriendSectionsBlock;
import org.example.elements.friendPage.RequestsBlock;

import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage extends LoadablePage implements WithToolbarPage {
  private final String FRIEND_SECTIONS_BLOCK = "//*[@id='UserFriendsCatalogRB']";
  private final String REQUESTS_BLOCK = "//*[@id='hook_Block_OutgoingFriendshipRequests']";
  final private FriendSectionsBlock friendSectionsBlock;
  final private RequestsBlock requestsBlock;

  public FriendsPage() {
    this.friendSectionsBlock = new FriendSectionsBlock($x(FRIEND_SECTIONS_BLOCK));
    this.requestsBlock = new RequestsBlock($x(REQUESTS_BLOCK));
  }

  public FriendSectionsBlock getFriendSectionsBlock() {
    return friendSectionsBlock;
  }

  public RequestsBlock getRequestsBlock() {
    return requestsBlock;
  }

  @Override
  protected void isLoaded() throws Error {
    $x(FRIEND_SECTIONS_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок секций друзей"));
    $x(REQUESTS_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок запросов"));
  }
}
