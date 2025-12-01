package maxdev.factory;

import maxdev.model.AudioBook;
import maxdev.model.Book;

public class AudioBookFactory extends BookFactory {
    @Override
    public Book createBook(String title) {
        return new AudioBook(title);
    }
}
