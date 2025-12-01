package maxdev;

import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import maxdev.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddRemoveBooks {

	@Test
	void testAddPaperBooks() {
		Library library = new Library();
		library.addBook(new PaperBookFactory().createBook("Clean Code"));
		library.addBook(new PaperBookFactory().createBook("Clean Architecture"));
		library.addBook(new PaperBookFactory().createBook("Design Patterns"));
		library.addBook(new PaperBookFactory().createBook("Agile Development"));

		assertEquals(4, library.booksCount());
	}

	@Test
	void testAddEBooks() {
		Library library = new Library();
		library.addBook(new EBookFactory().createBook("Clean Code"));
		library.addBook(new EBookFactory().createBook("Clean Architecture"));
		library.addBook(new EBookFactory().createBook("Design Patterns"));
		library.addBook(new EBookFactory().createBook("Agile Development"));

		assertEquals(4, library.booksCount());
	}

	@Test
	void testAddAudioBooks() {
		Library library = new Library();
		library.addBook(new AudioBookFactory().createBook("Clean Code"));
		library.addBook(new AudioBookFactory().createBook("Clean Architecture"));
		library.addBook(new AudioBookFactory().createBook("Design Patterns"));
		library.addBook(new AudioBookFactory().createBook("Agile Development"));

		assertEquals(4, library.booksCount());
	}

	@Test
	void testRemovePaperBook() {
		Library library = new Library();
		Book book = new PaperBookFactory().createBook("Clean Code");
		library.addBook(book);
		library.removeBook("Clean Code");

		assertEquals(0, library.booksCount());
	}

	@Test
	void testRemoveEBook() {
		Library library = new Library();
		Book book = new EBookFactory().createBook("Clean Architecture");
		library.addBook(book);
		library.removeBook("Clean Architecture");

		assertEquals(0, library.booksCount());
	}

	@Test
	void testRemoveAudioBook() {
		Library library = new Library();
		Book book = new AudioBookFactory().createBook("Design Patterns");
		library.addBook(book);
		library.removeBook("Design Patterns");

		assertEquals(0, library.booksCount());
	}

	@Test
	void testFindBookByTitle() {
		Library library = new Library();
		library.addBook(new PaperBookFactory().createBook("Agile Development"));

		assertTrue(library.findBookByTitle("Agile Development").isPresent());
	}

	@Test
	void testRemoveNonExistingBook() {
		Library library = new Library();
		library.addBook(new PaperBookFactory().createBook("Clean Code"));
		library.removeBook("Not A Book");

		assertEquals(1, library.booksCount());
	}
}
