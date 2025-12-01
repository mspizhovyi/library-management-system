package maxdev;

import maxdev.factory.PaperBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.AudioBookFactory;
import maxdev.model.Book;
import maxdev.model.Member;
import maxdev.service.BorrowingBookResult;
import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBorrowBooks {

	@Test
	void testBorrowPaperBook() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new PaperBookFactory().createBook("Clean Code");
		BorrowingBookResult r = m.borrowBook(book);
		assertTrue(r.isSuccess());
	}

	@Test
	void testBorrowEBook() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new EBookFactory().createBook("Clean Architecture");
		BorrowingBookResult r = m.borrowBook(book);
		assertTrue(r.isSuccess());
	}

	@Test
	void testBorrowAudioBook() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new AudioBookFactory().createBook("Design Patterns");
		BorrowingBookResult r = m.borrowBook(book);
		assertTrue(r.isSuccess());
	}

	@Test
	void testBorrowSameBookTwice() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new PaperBookFactory().createBook("Clean Code");

		m.borrowBook(book);
		BorrowingBookResult r = m.borrowBook(book);

		assertFalse(r.isSuccess());
		assertEquals("Book is currently unavailable.", r.getMessage());
	}

	@Test
	void testReturnBorrowedBook() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new PaperBookFactory().createBook("Agile Development");

		m.borrowBook(book);
		BorrowingBookResult r = m.returnBook(book);

		assertTrue(r.isSuccess());
	}

	@Test
	void testReturnBookNotBorrowed() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());
		Book book = new EBookFactory().createBook("Clean Code");

		BorrowingBookResult r = m.returnBook(book);

		assertFalse(r.isSuccess());
		assertEquals("Member did not borrow this book.", r.getMessage());
	}

	@Test
	void testBorrowLimitExceeded() {
		Member m = new Member("Alice", BorrowingServiceImpl.getInstance());

		m.borrowBook(new PaperBookFactory().createBook("Clean Code"));
		m.borrowBook(new PaperBookFactory().createBook("Clean Architecture"));
		m.borrowBook(new PaperBookFactory().createBook("Design Patterns"));

		BorrowingBookResult r =
				m.borrowBook(new PaperBookFactory().createBook("Agile Development"));

		assertFalse(r.isSuccess());
		assertEquals("Borrowing limit exceeded (max = 3).", r.getMessage());
	}

	@Test
	void testBorrowDifferentFactories() {
		Member m = new Member("Bob", BorrowingServiceImpl.getInstance());

		BorrowingBookResult r1 =
				m.borrowBook(new PaperBookFactory().createBook("Clean Code"));
		BorrowingBookResult r2 =
				m.borrowBook(new EBookFactory().createBook("Clean Architecture"));
		BorrowingBookResult r3 =
				m.borrowBook(new AudioBookFactory().createBook("Design Patterns"));

		assertTrue(r1.isSuccess());
		assertTrue(r2.isSuccess());
		assertTrue(r3.isSuccess());
	}
}
