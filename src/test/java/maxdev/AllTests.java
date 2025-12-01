package maxdev;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
		TestAddRemoveMembers.class,
		TestAddRemoveBooks.class,
		TestBorrowBooks.class,
		TestNotAvailableBook.class,
		TestController.class,
		TestFindClassString.class,
		TestRemoveMemberWithBooks.class,
		TestSingleton.class,
		TestMemberServices.class
})
public class AllTests { }
