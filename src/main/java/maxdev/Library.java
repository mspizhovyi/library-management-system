package maxdev;

import maxdev.model.Book;
import maxdev.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
	private final List<Member> members = new ArrayList<>();
	private final List<Book> books = new ArrayList<>();

	public void addMember(Member member) { members.add(member); }

	public void removeMember(String name) {
		findMemberByName(name).ifPresent(m -> {
			m.getBorrowedBooks().forEach(b -> b.setIsAvailable(true));
			m.getBorrowedBooks().clear();
			members.remove(m);
		});
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void removeBook(String title) {
		findBookByTitle(title).ifPresent(books::remove);
	}

	public Optional<Member> findMemberByName(String name) {
		return members
				.stream()
				.filter(m -> m.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	public Optional<Book> findBookByTitle(String title) {
		return books
				.stream()
				.filter(b -> b.getTitle().equalsIgnoreCase(title))
				.findFirst();
	}

	public int membersCount() {
		return members.size();
	}

	public int booksCount() {
		return books.size();
	}
}
