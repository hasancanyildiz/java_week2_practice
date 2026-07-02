import java.util.Comparator;
import java.util.List;

public class BookSorter {
    //sort methods:
    private SortStrategy strategy;
    public BookSorter (SortStrategy strategy){
        this.strategy=strategy;

    }
    public List<Book> sort (List<Book> books){
        return strategy.sort(books);
    }

}
