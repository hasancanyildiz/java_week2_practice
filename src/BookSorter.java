import java.util.Comparator;
import java.util.List;

public class BookSorter {
    //sort methods:
    public void sortedByYear (List<Book> books){
        System.out.println("Sorted by year : ");
        books.stream().sorted(Comparator.comparing(Book::year))
                .forEach(System.out::println);
    }
    // sort books by year
    public void reversSortedByYear (List<Book>books){
        System.out.println("Revers sorted by year : ");
        books.stream().sorted(Comparator.comparing(Book::year).reversed())
                .forEach(System.out::println);
    }
    // sort first by genre
    public void sortedByGenreAndYear(List<Book> books) {
        System.out.println("Sorted by genre after year: ");
        books.stream()
                .sorted(Comparator.comparing(Book::genre)
                        .thenComparing(Book::year)).forEach(System.out::println);
    }

}
