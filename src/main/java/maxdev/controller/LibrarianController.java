package maxdev.controller;

import maxdev.Library;
import maxdev.factory.*;
import maxdev.model.Book;
import maxdev.model.Member;
import maxdev.service.BorrowingService;
import maxdev.service.BorrowingServiceImpl;

import java.util.Optional;

public class LibrarianController {
	private final Library library = new Library();
	private final BorrowingService borrowingService = BorrowingServiceImpl.getInstance();

	private final BookFactory paperFactory = new PaperBookFactory();
	private final BookFactory ebookFactory = new EBookFactory();
	private final BookFactory audioFactory = new AudioBookFactory();

	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService));
	}

	public void addPaperBook(String title) {
		library.addBook(paperFactory.createBook(title));
	}

	public void addEBook(String title) {
		library.addBook(ebookFactory.createBook(title));
	}

	public void addAudioBook(String title) {
		library.addBook(audioFactory.createBook(title));
	}

	public void borrowBookByMember(String title, String name) {
		Optional<Member> member = library.findMemberByName(name);
		Optional<Book> book = library.findBookByTitle(title);

		member.ifPresent(m -> book.ifPresent(m::borrowBook));
	}

	public void returnBookByMember(String title, String name) {
		Optional<Member> member = library.findMemberByName(name);
		Optional<Book> book = library.findBookByTitle(title);

		member.ifPresent(m -> book.ifPresent(m::returnBook));
	}
}
