package maxdev.factory;

import maxdev.model.Book;
import maxdev.model.PaperBook;

public class PaperBookFactory extends BookFactory {

    @Override
    public Book createBook(String title) {
        return new PaperBook(title);
    }
}
