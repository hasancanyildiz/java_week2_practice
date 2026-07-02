import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    //It doesn't use Optional.of(), Optional.ofNullable() and Optional.empty() because .findFirst() returns optional in the streams.
    //find the first book that matches the given title
    public Optional<Book> findByTitle(List<Book> books, String title) {
        return books.stream()
                .filter(b ->b.title().equals(title))
                .findFirst();


    } // find the first book that matches the given author
    public Optional<Book> findByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b ->b.author().equals(author))
                .findFirst();


    }
    // find the most recently  book
    public Optional<Book> findLatestBook(List<Book> books) {
        return books.stream()
                .max(Comparator.comparing(Book::year));


    }
    // find books by one author
    public void authorFinder(List<Book> books, String author){
        System.out.println(author +"Books:");
        books.stream().filter(b -> b.author().equals(author))
                .forEach(System.out::println);

    }
}
