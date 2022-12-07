package org.example.elements.friendPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FriendSectionsBlock {
  public final String MENU_DROP_DOWN = ".//*[@class='mctc_navMenuDropdownSec']";
  public final String EMPTY_PANEL = ".//*[@class='stub-empty_t']";
  public final String OUTGOING_REQUESTS_BTN = ".//*[@data-l='t,userOutgoingFriendRequest']";
  private final String OUTGOING_REQUESTS_COUNT = "//*[@id='counter_outgoingFriendRequestsPage']";
  private final SelenideElement item;

  public FriendSectionsBlock(final SelenideElement item) {
    this.item = item;
  }

  public int getCountOutgoingRequests() {
    return Integer.parseInt($x(OUTGOING_REQUESTS_COUNT).text());
  }

  public boolean isOutgoingRequestsExist() {
    return !$x(EMPTY_PANEL).exists();
  }

  public FriendSectionsBlock clickOutgoingRequests() {
    $x(MENU_DROP_DOWN).click();
    $x(OUTGOING_REQUESTS_BTN).shouldBe(visible);
    $x(OUTGOING_REQUESTS_BTN).click();
    return this;
  }
}
