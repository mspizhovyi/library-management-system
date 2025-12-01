package maxdev.model;

public class EBook implements Book {

    private final String title;
    private boolean isAvailable = true;

    public EBook(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean getIsAvailable() {
        return isAvailable;
    }

    @Override
    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "EBook: " + title;
    }
}
