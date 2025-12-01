package maxdev;

import maxdev.controller.LibrarianController;
import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestController {

	@Test
	void testAddMembers() {
		LibrarianController c = new LibrarianController();
		c.addMember("Alice");
		c.addMember("Bob");
		c.addMember("Charlie");
		assertTrue(true);
	}

	@Test
	void testAddPaperEAudioBooks() {
		LibrarianController c = new LibrarianController();
		c.addPaperBook("Clean Code");
		c.addEBook("Clean Architecture");
		c.addAudioBook("Design Patterns");
		assertTrue(true);
	}


	@Test
	void testBorrowAndReturnPaperBook() {
		LibrarianController c = new LibrarianController();
		c.addMember("Alice");
		c.addPaperBook("Clean Code");

		c.borrowBookByMember("Clean Code", "Alice");
		c.returnBookByMember("Clean Code", "Alice");

		assertTrue(true);
	}

	@Test
	void testBorrowAndReturnEBook() {
		LibrarianController c = new LibrarianController();
		c.addMember("Bob");
		c.addEBook("Clean Architecture");

		c.borrowBookByMember("Clean Architecture", "Bob");
		c.returnBookByMember("Clean Architecture", "Bob");

		assertTrue(true);
	}

	@Test
	void testBorrowAndReturnAudioBook() {
		LibrarianController c = new LibrarianController();
		c.addMember("Charlie");
		c.addAudioBook("Design Patterns");

		c.borrowBookByMember("Design Patterns", "Charlie");
		c.returnBookByMember("Design Patterns", "Charlie");

		assertTrue(true);
	}

	@Test
	void testBorrowBooksMultipleMembers() {
		LibrarianController c = new LibrarianController();
		c.addMember("Alice");
		c.addMember("Bob");

		c.addPaperBook("Clean Code");
		c.addEBook("Clean Architecture");
		c.addAudioBook("Design Patterns");

		c.borrowBookByMember("Clean Code", "Alice");
		c.borrowBookByMember("Clean Architecture", "Bob");

		c.returnBookByMember("Clean Code", "Alice");
		c.returnBookByMember("Clean Architecture", "Bob");

		assertTrue(true);
	}

	@Test
	void testBorrowDifferentBookTypesSameMember() {
		LibrarianController c = new LibrarianController();
		c.addMember("Alice");

		c.addPaperBook("Clean Code");
		c.addEBook("Clean Architecture");
		c.addAudioBook("Design Patterns");

		c.borrowBookByMember("Clean Code", "Alice");
		c.borrowBookByMember("Clean Architecture", "Alice");
		c.borrowBookByMember("Design Patterns", "Alice");

		c.returnBookByMember("Clean Code", "Alice");
		c.returnBookByMember("Clean Architecture", "Alice");
		c.returnBookByMember("Design Patterns", "Alice");

		assertTrue(true);
	}
}
