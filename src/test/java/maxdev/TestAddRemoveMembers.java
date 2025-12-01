package maxdev;

import maxdev.model.Member;
import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddRemoveMembers {

	@Test
	void testAddSingleMember() {
		Library library = new Library();
		library.addMember(new Member("Alice", BorrowingServiceImpl.getInstance()));
		assertEquals(1, library.membersCount());
	}

	@Test
	void testAddMultipleMembers() {
		Library library = new Library();
		library.addMember(new Member("Alice", BorrowingServiceImpl.getInstance()));
		library.addMember(new Member("Bob", BorrowingServiceImpl.getInstance()));
		library.addMember(new Member("Charlie", BorrowingServiceImpl.getInstance()));
		assertEquals(3, library.membersCount());
	}

	@Test
	void testRemoveMemberByName() {
		Library library = new Library();
		library.addMember(new Member("Alice", BorrowingServiceImpl.getInstance()));
		library.removeMember("Alice");
		assertEquals(0, library.membersCount());
	}

	@Test
	void testRemoveNonExistingMember() {
		Library library = new Library();
		library.addMember(new Member("Alice", BorrowingServiceImpl.getInstance()));
		library.removeMember("Bob");
		assertEquals(1, library.membersCount());
	}
}
