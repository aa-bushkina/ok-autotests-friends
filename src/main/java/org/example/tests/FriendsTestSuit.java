package org.example.tests;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"org.example.tests"})
@IncludeTags({"development", "production"})
@Suite
@SuiteDisplayName("All friends Tests Suite")
public class FriendsTestSuit {

}