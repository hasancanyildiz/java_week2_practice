public class BookBuilder {


        private String title;
        private String author;
        private int year;
        private String genre;
        private boolean available;

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }
    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder year(int year) {
        this.year = year;
        return this;
    }

    public BookBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder available(boolean available) {
        this.available = available;
        return this;
    }
    public Book build() {
        return new Book(title, author, year, genre, available);
    }
}