package org.example.pages.utils;

import org.example.pages.*;

public class PageFactory {
  public static LoadablePage createPage(final PageType pageType) {
    return switch (pageType) {
      case Login -> new LoginPage();
      case Friends -> new FriendsPage();
      case News -> new NewsPage();
      case User -> new UserPage();
      case OtherFriends -> new OtherFriendsPage();
    };
  }
}
