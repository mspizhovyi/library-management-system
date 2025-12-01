package maxdev.model;

public class AudioBook implements Book {

    private final String title;
    private boolean isAvailable = true;

    public AudioBook(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean getIsAvailable() { return isAvailable; }

    @Override
    public void setIsAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() { return "AudioBook: " + title; }
}
