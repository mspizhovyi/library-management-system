package maxdev.service;

import maxdev.model.Book;
import maxdev.model.Member;

public interface BorrowingService {
    BorrowingBookResult borrowBook(Member member, Book book);
    BorrowingBookResult returnBook(Member member, Book book);
}
