import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //used some var examples.
        var books = LibraryData.creatSempleBooks();
        var  bookRepo =BookRepository.getInstance();
        // get the sample book list
        bookRepo.authorFinder(books, "Stephen King");
        //maka a sorter object and use to sort
        System.out.println();
        System.out.println("Sorted by year ");
        BookSorter sorter = new BookSorter(new SortByYear());
        sorter.sort(books).forEach(System.out::println);

        System.out.println();
        System.out.println(" Sorted by year reversed ");
        BookSorter sorter2 = new BookSorter(new ReversSortedByYear());
        sorter2.sort(books).forEach(System.out::println);

        System.out.println();
        System.out.println(" Sorted by genre then year ");
        BookSorter sorter3 = new BookSorter(new SortedByGenreAndYear());
        sorter3.sort(books).forEach(System.out::println);

        System.out.println();

        //Factory pattern part
        BookReportService reportService = new BookReportService(NotificationFactory.creatNotification("console"));
        reportService.LibReport(books);

        BookReportService reportService2 =new BookReportService(NotificationFactory.creatNotification("email"));
        reportService2.LibReport(books);
        System.out.println();
        reportService.printOfAllTitles(books);
        reportService.printOfAvailableTitles(books);
        reportService.printGroupingByGenre(books);
        reportService.printCountOfGenres(books);
        reportService.printAvgYear(books);
        reportService.LibReport(books);

        //equel test
        var b1 = new Book("Dune", "Frank Herbert", 1965, "Sci-Fi", false);
        var b2 = new Book("Dune", "Frank Herbert", 1965, "Sci-Fi", false);
        System.out.println("equals: " + b1.equals(b2)); // it should be true
        optionalExamples(books, bookRepo );

        //Day 4 Pattern applications
        //Builder pattern part
        Book bookBuild = new BookBuilder()
                .title("Dune")
                .author("Frank Herbert")
                .year(1965)
                .genre("Sci-Fi")
                .available(false)
                .build();
        System.out.println("The Book that I used builder pattern");
        System.out.println(bookBuild);





    }




        private static void optionalExamples(List<Book> books, BookRepository repo){
            Book found = repo.findByTitle(books,"Dune").orElseThrow(() -> new RuntimeException("Not found"));
            System.out.println("Found :" +found.title());
            // Book found_2 = repo.findByTitle(books,"Faust").orElseThrow(() -> new RuntimeException("Not found"));
// System.out.println("Found :" +found_2.title());
            repo.findByTitle(books,"1984")
                   .ifPresent(b ->System.out.println("if present : "+b.title()));

            Book result =repo.findByTitle(books,"Harry Potter")
                    .orElse(new Book("Unknown", "Unknown", 0, "Unknown", false));
            System.out.println("orElse :"+result.title());

            String title = repo.findByTitle(books, "Dune")
                    .map(b -> b.title())
                    .orElse("Not found");
            System.out.println("map: " + title);

            repo.findLatestBook(books)
                    .ifPresent(b -> System.out.println("Most recent: " + b.title()));
        }


}


