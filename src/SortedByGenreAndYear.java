import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedByGenreAndYear implements SortStrategy{
    public List<Book> sort(List<Book> books){
        return books.stream().sorted(Comparator.comparing(Book::genre).thenComparing(Book::year))
                .collect(Collectors.toList());
    }
}
