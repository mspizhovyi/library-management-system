package maxdev.service;

import maxdev.model.Book;
import maxdev.model.Member;

public class BorrowingServiceImpl implements BorrowingService {
    private static volatile BorrowingServiceImpl INSTANCE;

    private BorrowingServiceImpl() {}

    public static BorrowingServiceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (BorrowingServiceImpl.class) {
                if(INSTANCE == null) {
                    INSTANCE = new BorrowingServiceImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {

        if (!book.getIsAvailable()) {
            return new BorrowingBookResult(false, "Book is currently unavailable.");
        }

        if (member.hasBorrowed(book)) {
            return new BorrowingBookResult(false, "Member already borrowed this book.");
        }

        int borrowingLimit = 3;
        if (member.borrowedBooksCount() >= borrowingLimit) {
            return new BorrowingBookResult(false, String.format("Borrowing limit exceeded (max = %d).", 3));
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
