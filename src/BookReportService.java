import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookReportService {
    private NotificationService notificationService;

    public BookReportService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    // get only the titles of all books
    public void printOfAllTitles(List<Book> books){
        List<String> titles =books.stream().map(Book::title)
                .collect(Collectors.toList());
        System.out.println("All titles :");
        titles.forEach(System.out::println);
    }
    // get titles of books that are available now
    public void printOfAvailableTitles(List<Book> books){
        List<String> availableTitles =books.stream().filter(Book::available).map(Book::title)
                .collect(Collectors.toList());
        System.out.println("All available titles :");
        availableTitles.forEach(System.out::println);
    }

    // group books by genre
    public void printGroupingByGenre(List<Book> books){
        Map<String,List<Book>> byGenre =books.stream()
                .collect(Collectors.groupingBy(Book::genre));
        for (Map.Entry<String,List<Book>> entry :byGenre.entrySet()){
            System.out.println(entry.getKey() + ":");
            for (Book b : entry.getValue()) {
                System.out.println("  " + b.title());
            }

        }
    }
    // count how many books are in each genre
    public void printCountOfGenres(List<Book> books){
        Map<String,Long> countByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre,Collectors.counting()));
        for (Map.Entry<String, Long> entry : countByGenre.entrySet()){
            System.out.println(entry.getKey() + ":"+ entry.getValue());

        }
        System.out.println();
    }// find the average publish year of all books
    public void printAvgYear(List<Book> books){
        System.out.println("Average Year");
        double avgYear =books.stream().mapToInt(Book::year).average().orElse(0);
        System.out.println("average: " + avgYear);
    }
    // make a small report: book count and average year for each genre
    public void LibReport(List<Book> books){
        System.out.println("Library Report :");
        Map <String,List<Book>>  byGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre));
        for (Map.Entry<String,List<Book>>entry:byGenre.entrySet()){
            String genre = entry.getKey();
            List<Book> genreBooks = entry.getValue();
            double avgYear = genreBooks.stream()
                    .mapToInt(Book::year)
                    .average()
                    .orElse(0);

            System.out.println(genre + "  :" + genreBooks.size() + " Average year of the book: " + avgYear);

        }
        notificationService.notify("Library report is ready!");
    }
}
