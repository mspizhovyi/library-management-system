package maxdev.factory;

import maxdev.model.Book;
import maxdev.model.EBook;

public class EBookFactory extends BookFactory {

    @Override
    public Book createBook(String title) {
        return new EBook(title);
    }
}
