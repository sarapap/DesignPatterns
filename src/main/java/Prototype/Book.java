package Prototype;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for Book", e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s, %d)", title, author, genre, publicationYear);
    }
}
