import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Book> books = LibraryData.creatSempleBooks();
        BookRepository bookRepo =new BookRepository();
        // get the sample book list
        authorFinder(books, "Stephen King");
        sortedByYear(books);
        reversSortedByYear(books);
        sortedByGenreAndYear(books);
        printOfAllTitles(books);
        printOfAvailableTitles(books);
        printGroupingByGenre(books);
        printCountOfGenres(books);
        printAvgYear(books);
        LibReport(books);

        //equel test
        Book b1 = new Book("Dune", "Frank Herbert", 1965, "Sci-Fi", false);
        Book b2 = new Book("Dune", "Frank Herbert", 1965, "Sci-Fi", false);
        System.out.println("equals: " + b1.equals(b2)); // it should be true
        optionalExamples(books, bookRepo );



    }
    // find books by one author
        private static void authorFinder(List<Book> books, String author){
            System.out.println(author +"Books:");
            books.stream().filter(b -> b.author().equals(author))
                    .forEach(System.out::println);

        }
        //sort methods:
        private static void sortedByYear (List<Book> books){
            System.out.println("Sorted by year : ");
            books.stream().sorted(Comparator.comparing(Book::year))
                    .forEach(System.out::println);
        }
    // sort books by year
        private static void reversSortedByYear (List<Book>books){
            System.out.println("Revers sorted by year : ");
            books.stream().sorted(Comparator.comparing(Book::year).reversed())
                    .forEach(System.out::println);
        }
        // sort first by genre
        private static void sortedByGenreAndYear(List<Book> books) {
            System.out.println("Sorted by genre after year: ");
            books.stream()
                    .sorted(Comparator.comparing(Book::genre)
                            .thenComparing(Book::year)).forEach(System.out::println);
        }
        // get only the titles of all books
        private static void printOfAllTitles(List<Book> books){
            List<String> titles =books.stream().map(Book::title)
                    .collect(Collectors.toList());
            System.out.println("All titles :");
            titles.forEach(System.out::println);
        }
        // get titles of books that are available now
        private static void printOfAvailableTitles(List<Book> books){
            List<String> availableTitles =books.stream().filter(Book::available).map(Book::title)
                    .collect(Collectors.toList());
            System.out.println("All available titles :");
            availableTitles.forEach(System.out::println);
        }

        // group books by genre
        private static void printGroupingByGenre(List<Book> books){
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
        private static void printCountOfGenres(List<Book> books){
            Map<String,Long> countByGenre = books.stream()
                    .collect(Collectors.groupingBy(Book::genre,Collectors.counting()));
            for (Map.Entry<String, Long> entry : countByGenre.entrySet()){
                System.out.println(entry.getKey() + ":"+ entry.getValue());

            }
            System.out.println();
        }// find the average publish year of all books
        private static void printAvgYear(List<Book> books){
            System.out.println("Average Year");
            double avgYear =books.stream().mapToInt(Book::year).average().orElse(0);
            System.out.println("average: " + avgYear);
        }
    // make a small report: book count and average year for each genre
        private static void LibReport(List<Book> books){
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


