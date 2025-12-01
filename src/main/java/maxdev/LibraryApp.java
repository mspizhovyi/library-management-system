package maxdev;

import maxdev.controller.LibrarianController;

public class LibraryApp {
	private static final LibrarianController librarian = new LibrarianController();

	public static void main(String[] args) {
		librarian.addPaperBook("Dune");
		librarian.addMember("Alice");

		librarian.borrowBookByMember("Dune", "Alice");
		librarian.returnBookByMember("Dune", "Alice");
	}
}
