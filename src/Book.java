public class Book {
    private String title;
    private String author;
    private int year;
    private String genre;
    private boolean available;
    //constructor method
    public Book (String title,String author,int year,String genre, boolean available){
        this.title=title;
        this.author=author;
        this.year=year;
        this.genre=genre;
        this.available=available;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle(){
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }
    @Override
    public String toString(){
        return title + " by " + author + " (" + year + ") - " + genre;
    }
}
