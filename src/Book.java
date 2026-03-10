import java.time.Year;

public class Book {
    private String isbn13;
    private String title;
    private String[] author;
    private String publisher;
    private int publicationYear;
    private String language;
    private boolean available = true;


    //Constructors
      //Default constructors
    public Book() {
        this.isbn13 = "";
        this.title = "";
        this.author = new String[0];
        this.publisher = "";
        this.publicationYear = 0;
        this.language = "";
        this.available = true;
    }
    //Non-default constructors
    public Book(String isbn13, String title, String[] author, String publisher, int publicationYear) {
        setIsbn13(isbn13);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setPublicationYear(publicationYear);
        this.language = "";
        this.available = true;

    }
    //Getter
    public String getIsbn13() {
        return isbn13;
    }
    public String getTitle() {
        return title;
    }
    public String[] getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public String getLanguage() {
        return language;
    }
    public boolean isAvailable() {
        return available;
    }
    public String getPrimaryAuthor() {
        return author[0];
    }
    public String getSecondaryAuthor() {
        return author.length > 1 ? author[1] : "";
    }
    //Setter
    public void setIsbn13(String isbn13) {
        if (isbn13 != null && isbn13.matches("\\d{13}") ) {
            this.isbn13 = isbn13;
        }else{
            System.out.println("Invalid ISBN 13 number");
        }
    }
    public void setTitle(String title) {
        if (title == null ) {
            System.out.println("Title is null");
        }else {
            this.title = title;
        }
    }
    public void setAuthor(String[] author) {
        if (author != null && author.length >= 1) {
            this.author = author;
        } else {
            System.out.println("Author list must have at least one name!");
        }
    }

    public void setPublisher(String publisher) {
        if (publisher == null ) {
            System.out.println("Publisher is empty!");
        }else {
            this.publisher = publisher;
        }
    }
    public void setPublicationYear(int publicationYear) {
        int currentYear = Year.now().getValue(); //gets the actual current year
        if (publicationYear >= 1500 && publicationYear <= currentYear) {
            this.publicationYear = publicationYear;
        }else {
            System.out.println("Invalid publication year Must be between 1500 and " + currentYear + "!");
        }
    }
    public void setLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            this.language = language;
        } else {
            System.out.println("Language cannot be empty!");
        }
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    //Behavioral Methods
    public void markAvailable() {
        this.available = true;
    }
    public void markUnavailable() {
        this.available = false;
    }
}
