import java.util.ArrayList;
import java.util.List;

public class LibraryData {
    public static List<Book> creatSempleBooks(){
        ArrayList<Book> list =new ArrayList<>();
        list.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy", true));
        list.add(new Book("Dune", "Frank Herbert", 1965, "Sci-Fi", false));
        list.add(new Book("1984", "George Orwell", 1949, "Sci-Fi", true));
        list.add(new Book("The Shining", "Stephen King", 1977, "Mystery", false));
        list.add(new Book("Foundation", "Isaac Asimov", 1951, "Sci-Fi", true));
        list.add(new Book("A Game of Thrones", "George R.R. Martin", 1996, "Fantasy", false));
        list.add(new Book("Murder on the Orient Express", "Agatha Christie", 1934, "Mystery", true));
        list.add(new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance", true));
        list.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "Fantasy", false));
        list.add(new Book("Sapiens", "Yuval Noah Harari", 2011, "History", true));
        list.add(new Book("Neuromancer", "William Gibson", 1984, "Sci-Fi", false));
        list.add(new Book("The Da Vinci Code", "Dan Brown", 2003, "Mystery", true));
        list.add(new Book("Outlander", "Diana Gabaldon", 1991, "Romance", false));
        list.add(new Book("Guns, Germs, and Steel", "Jared Diamond", 1997, "History", true));
        list.add(new Book("Mistborn", "Brandon Sanderson", 2006, "Fantasy", true));
        list.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 2005, "Mystery", false));
        list.add(new Book("The Martian", "Andy Weir", 2014, "Sci-Fi", true));
        list.add(new Book("A People's History of the US", "Howard Zinn", 1980, "History", false));

        return list;

    }
}
