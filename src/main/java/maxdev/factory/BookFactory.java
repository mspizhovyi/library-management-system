package maxdev.factory;

import maxdev.model.Book;

public abstract class BookFactory {
    public abstract Book createBook(String title);
}
