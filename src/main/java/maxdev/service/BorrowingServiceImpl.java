package maxdev.service;

import maxdev.model.Book;
import maxdev.model.Member;

public class BorrowingServiceImpl implements BorrowingService {
    private static volatile BorrowingServiceImpl instance;
    private final int BORROWING_LIMIT = 3;

    private BorrowingServiceImpl() {}

    public static BorrowingServiceImpl getInstance() {
        if (instance == null) {
            synchronized (BorrowingServiceImpl.class) {
                if(instance == null) {
                    instance = new BorrowingServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {

        if (!book.getIsAvailable()) {
            return new BorrowingBookResult(false, "Book is currently unavailable.");
        }

        if (member.hasBorrowed(book)) {
            return new BorrowingBookResult(false, "Member already borrowed this book.");
        }

        if (member.borrowedBooksCount() >= BORROWING_LIMIT) {
            return new BorrowingBookResult(false, "Borrowing limit exceeded (max = 3).");
        }

        book.setIsAvailable(false);
        member.addBorrowedBook(book);

        return new BorrowingBookResult(true, "Book borrowed successfully.");
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {

        if (!member.hasBorrowed(book)) {
            return new BorrowingBookResult(false, "Member did not borrow this book.");
        }

        member.removeBorrowedBook(book);
        book.setIsAvailable(true);

        return new BorrowingBookResult(true, "Book returned successfully.");
    }
}
