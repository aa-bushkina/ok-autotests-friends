package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.elements.otherFriendsPage.OtherFriendSectionsBlock;
import org.example.elements.otherFriendsPage.OtherSubscribersBlock;

import static com.codeborne.selenide.Selenide.$x;

public class OtherFriendsPage extends LoadablePage implements WithToolbarPage {
  private final String FRIEND_SECTIONS_BLOCK = "//*[@id='FriendFriendsCatalogRB']";
  private final String SUBSCRIBERS_BLOCK = "//*[@id='hook_Block_FriendSubscribersPageMRB']";
  final private OtherFriendSectionsBlock friendSectionsBlock;
  final private OtherSubscribersBlock requestsBlock;

  public OtherFriendsPage() {
    this.friendSectionsBlock = new OtherFriendSectionsBlock($x(FRIEND_SECTIONS_BLOCK));
    this.requestsBlock = new OtherSubscribersBlock($x(SUBSCRIBERS_BLOCK));
  }

  public OtherFriendSectionsBlock getOtherFriendSectionsBlock() {
    return friendSectionsBlock;
  }

  public OtherSubscribersBlock getOtherSubscribersBlock() {
    return requestsBlock;
  }

  @Override
  protected void isLoaded() throws Error {
    $x(FRIEND_SECTIONS_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок секций друзей"));
    $x(SUBSCRIBERS_BLOCK).shouldBe(Condition.visible.because("Не отобразился блок подписчиков"));
  }
}
