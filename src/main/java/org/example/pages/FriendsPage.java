package org.example.pages;

import org.example.pages.elements.friendSections.FriendSectionsBlock;
import org.example.pages.elements.friendSections.RequestsBlock;
import org.example.pages.elements.toolbar.Toolbar;

import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage extends LoadablePage
{
  private final String FRIEND_SECTIONS_BLOCK = "//*[@id='UserFriendsCatalogRB']";
  private final String REQUESTS_BLOCK = "//*[@id='hook_Block_OutgoingFriendshipRequests']";
  final private FriendSectionsBlock friendSectionsBlock;
  final private RequestsBlock requestsBlock;

  public FriendsPage()
  {
    this.friendSectionsBlock = new FriendSectionsBlock($x(FRIEND_SECTIONS_BLOCK));
    this.requestsBlock = new RequestsBlock($x(REQUESTS_BLOCK));
  }

  public FriendSectionsBlock getFriendSectionsBlock()
  {
    return friendSectionsBlock;
  }

  public RequestsBlock getRequestsBlock()
  {
    return requestsBlock;
  }

  @Override
  public Toolbar getToolbar()
  {
    return super.getToolbar();
  }

  @Override
  protected void isLoaded() throws Error
  {

  }

  public int getCountOutgoingRequests()
  {
    return friendSectionsBlock.getCountOutgoingRequests();
  }
}
