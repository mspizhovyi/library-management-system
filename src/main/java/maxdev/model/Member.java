package maxdev.model;

import maxdev.service.BorrowingBookResult;
import maxdev.service.BorrowingService;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private final String name;
	private final List<Book> borrowedBooks = new ArrayList<>();
	private final BorrowingService borrowingService;

	public Member(String name, BorrowingService service) {
		this.name = name;
		this.borrowingService = service;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public boolean hasBorrowed(Book book) {
		return borrowedBooks.contains(book);
	}

	public void addBorrowedBook(Book book) {
		borrowedBooks.add(book);
	}

	public void removeBorrowedBook(Book book) {
		borrowedBooks.remove(book);
	}

	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}

	public BorrowingBookResult borrowBook(Book book) {
		return borrowingService.borrowBook(this, book);
	}

	public BorrowingBookResult returnBook(Book book) {
		return borrowingService.returnBook(this, book);
	}

	public BorrowingService getBorrowingService() {
		return borrowingService;
	}



	@Override
	public String toString() {
		return "Member: " + name;
	}
}
