package maxdev;

import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import maxdev.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFindClassString {

	@Test
	void testPaperBookToStringContainsTitle() {
		Book book = new PaperBookFactory().createBook("Clean Code");
		assertTrue(book.toString().contains("Clean Code"));
	}

	@Test
	void testPaperBookToStringHasType() {
		Book book = new PaperBookFactory().createBook("Clean Code");
		assertTrue(book.toString().contains("PaperBook"));
	}

	@Test
	void testEBookToStringContainsTitle() {
		Book book = new EBookFactory().createBook("Clean Architecture");
		assertTrue(book.toString().contains("Clean Architecture"));
	}

	@Test
	void testEBookToStringHasType() {
		Book book = new EBookFactory().createBook("Clean Architecture");
		assertTrue(book.toString().contains("EBook"));
	}

	@Test
	void testAudioBookToStringContainsTitle() {
		Book book = new AudioBookFactory().createBook("Design Patterns");
		assertTrue(book.toString().contains("Design Patterns"));
	}

	@Test
	void testAudioBookToStringHasType() {
		Book book = new AudioBookFactory().createBook("Design Patterns");
		assertTrue(book.toString().contains("AudioBook"));
	}

	@Test
	void testAnotherPaperBook() {
		Book book = new PaperBookFactory().createBook("Agile Development");
		assertTrue(book.toString().contains("Agile Development"));
		assertTrue(book.toString().contains("PaperBook"));
	}
}
