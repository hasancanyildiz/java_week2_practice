import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Book> books = LibraryData.creatSempleBooks();

        authorFinder(books, "Stephen King");
    }

        private static void authorFinder(List<Book> books, String author){
            System.out.println(author +"Books:");
            books.stream().filter(b -> b.getAuthor().equals(author))
                    .forEach(System.out::println);

        }
        //sort methods:
        private static void sortedByYear (List<Book> books){
            System.out.println("Sorted by year : ");
            books.stream().sorted(Comparator.comparing(Book::getYear))
                    .forEach(System.out::println);
        }
        private static void reversSortedByYear (List<Book>books){
            System.out.println("Revers sorted by year : ");
            books.stream().sorted(Comparator.comparing(Book::getYear).reversed())
                    .forEach(System.out::println);
        }
        private static void sortedByGenreAndYear(List<Book> books) {
            System.out.println("Sorted by genre after year: ");
            books.stream()
                    .sorted(Comparator.comparing(Book::getGenre)
                            .thenComparing(Book::getYear)).forEach(System.out::println);
        }
        




}


