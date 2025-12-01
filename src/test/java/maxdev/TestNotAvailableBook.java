package maxdev;

import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import maxdev.model.Book;
import maxdev.model.Member;
import maxdev.service.BorrowingBookResult;
import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotAvailableBook {

	@Test
	void testPaperBookUnavailableThenAvailable() {
		Member a = new Member("Alice", BorrowingServiceImpl.getInstance());
		Member b = new Member("Bob", BorrowingServiceImpl.getInstance());

		Book book = new PaperBookFactory().createBook("Clean Code");

		a.borrowBook(book);
		BorrowingBookResult r1 = b.borrowBook(book);
		assertFalse(r1.isSuccess());

		a.returnBook(book);
		BorrowingBookResult r2 = b.borrowBook(book);
		assertTrue(r2.isSuccess());
	}

	@Test
	void testEBookUnavailableThenAvailable() {
		Member a = new Member("Alice", BorrowingServiceImpl.getInstance());
		Member b = new Member("Bob", BorrowingServiceImpl.getInstance());

		Book book = new EBookFactory().createBook("Clean Architecture");

		a.borrowBook(book);
		BorrowingBookResult r1 = b.borrowBook(book);
		assertFalse(r1.isSuccess());

		a.returnBook(book);
		BorrowingBookResult r2 = b.borrowBook(book);
		assertTrue(r2.isSuccess());
	}

	@Test
	void testAudioBookUnavailableThenAvailable() {
		Member a = new Member("Alice", BorrowingServiceImpl.getInstance());
		Member b = new Member("Bob", BorrowingServiceImpl.getInstance());

		Book book = new AudioBookFactory().createBook("Design Patterns");

		a.borrowBook(book);
		BorrowingBookResult r1 = b.borrowBook(book);
		assertFalse(r1.isSuccess());

		a.returnBook(book);
		BorrowingBookResult r2 = b.borrowBook(book);
		assertTrue(r2.isSuccess());
	}

	@Test
	void testMultipleUnavailableBooksDifferentTypes() {
		Member a = new Member("Alice", BorrowingServiceImpl.getInstance());
		Member b = new Member("Bob", BorrowingServiceImpl.getInstance());

		Book p = new PaperBookFactory().createBook("Clean Code");
		Book e = new EBookFactory().createBook("Clean Architecture");
		Book aud = new AudioBookFactory().createBook("Agile Development");

		a.borrowBook(p);
		a.borrowBook(e);
		a.borrowBook(aud);

		assertFalse(b.borrowBook(p).isSuccess());
		assertFalse(b.borrowBook(e).isSuccess());
		assertFalse(b.borrowBook(aud).isSuccess());

		a.returnBook(p);
		a.returnBook(e);
		a.returnBook(aud);

		assertTrue(b.borrowBook(p).isSuccess());
		assertTrue(b.borrowBook(e).isSuccess());
		assertTrue(b.borrowBook(aud).isSuccess());
	}
}
