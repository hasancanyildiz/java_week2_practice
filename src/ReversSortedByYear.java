import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReversSortedByYear implements SortStrategy {
    @Override
    public List<Book> sort(List<Book> books){
        return books.stream().sorted(Comparator.comparing(Book::year).reversed())
                .collect(Collectors.toList());
    }
}
