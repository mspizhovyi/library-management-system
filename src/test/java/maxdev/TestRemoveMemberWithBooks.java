package maxdev;

import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import maxdev.model.Book;
import maxdev.model.Member;
import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRemoveMemberWithBooks {

	@Test
	void testRemovingMemberReturnsPaperBook() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book b = new PaperBookFactory().createBook("Clean Code");

		library.addMember(alice);
		library.addBook(b);
		alice.borrowBook(b);

		library.removeMember("Alice");

		assertTrue(b.getIsAvailable());
	}

	@Test
	void testRemovingMemberReturnsEBook() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book b = new EBookFactory().createBook("Clean Architecture");

		library.addMember(alice);
		library.addBook(b);
		alice.borrowBook(b);

		library.removeMember("Alice");

		assertTrue(b.getIsAvailable());
	}

	@Test
	void testRemovingMemberReturnsAudioBook() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book b = new AudioBookFactory().createBook("Design Patterns");

		library.addMember(alice);
		library.addBook(b);
		alice.borrowBook(b);

		library.removeMember("Alice");

		assertTrue(b.getIsAvailable());
	}

	@Test
	void testRemovingMemberReturnsMultipleTypes() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());

		Book p = new PaperBookFactory().createBook("Clean Code");
		Book e = new EBookFactory().createBook("Clean Architecture");
		Book a = new AudioBookFactory().createBook("Agile Development");

		library.addMember(alice);
		library.addBook(p);
		library.addBook(e);
		library.addBook(a);

		alice.borrowBook(p);
		alice.borrowBook(e);
		alice.borrowBook(a);

		library.removeMember("Alice");

		assertTrue(p.getIsAvailable());
		assertTrue(e.getIsAvailable());
		assertTrue(a.getIsAvailable());
	}

	@Test
	void testMemberBorrowListClearedAfterRemoval() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book b = new PaperBookFactory().createBook("Clean Code");

		library.addMember(alice);
		library.addBook(b);
		alice.borrowBook(b);

		library.removeMember("Alice");

		assertEquals(0, library.membersCount());
	}

	@Test
	void testLibraryContainsNoBorrowedBooksAfterRemoval() {
		Library library = new Library();
		Member alice = new Member("Alice", BorrowingServiceImpl.getInstance());

		Book p = new PaperBookFactory().createBook("Clean Code");
		Book e = new EBookFactory().createBook("Clean Architecture");

		library.addMember(alice);
		library.addBook(p);
		library.addBook(e);

		alice.borrowBook(p);
		alice.borrowBook(e);

		library.removeMember("Alice");

		assertTrue(p.getIsAvailable());
		assertTrue(e.getIsAvailable());
	}
}
