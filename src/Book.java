import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    private int bookId;
    private String isbn13;
    private String title;
    private String[] author;
    private String publisher;
    private int publicationYear;
    private String language;
    private boolean available;
    private String format;
    private int pageCount;
    private String description;
    private String[] editor;
    private String subject;
    private int stock;
    private BookItem bookItem;

    public static  class Validator{
        public  boolean isValid(String isbn, String title) {
            return isIsbnValid(isbn) && isTitleValid(title);
        }
        private Boolean isIsbnValid(String isbn) {
            return !isbn.isEmpty();
        }
        private boolean isTitleValid(String title) {
            return !title.isEmpty();
        }
        public boolean isIsbnvalid(String isbn13) {
            if(isbn13.length() == 13) {
                return true;
            }else {
                return false;
            }
        }
        public boolean isTitlevalid(String title) {
            if(!title.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
        public boolean isValidStock(int stock){
            if(stock >= 0){
                return true;
            }else{
                return false;
            }
        }
    }
    public class StockManager{
        public int getAvailabeCount(){
            return stock;

        }
        public boolean canAddMore(int shelfLimit){
            if(stock < shelfLimit){
                return true;

            }else{
                return false;
            }
        }
    }


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
        this.format = "";
        this.pageCount = 0;
        this.description = "";
        this.editor = new String[0];
        this.subject = "";
        this.stock = 0;
        this.bookItem = null;
    }

    //Non-default constructors
    public Book(String isbn13, String title, String[] author, String publisher, String publicationYear, String language, boolean available, String format, int pageCount, String description, String[] editor, String subject) {
        setIsbn13(isbn13);
        setTitle(title);
        setAuthor(Arrays.toString(author));
        setPublisher(publisher);
        setPublicationYear(publicationYear);
        this.language = "";
        this.available = true;
        this.format = format;
        this.pageCount = pageCount;
        this.description = description;
        this.editor = editor;
        this.subject = subject;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.stock = 0;
    }

    //Getter
    public int getBookId() {
        return bookId;
    }

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

    public String getFormat() {
        return format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getDescription() {
        return description;

    }

    public int getStock() {
        return stock;
    }

    public String[] getEditor() {
        return editor;
    }

    public String getSubject() {
        return subject;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    //Setter
    public boolean setIsbn13(String isbn13) {
        if (isbn13 != null && isbn13.matches("\\d{13}")) {
            this.isbn13 = isbn13;
            return true;
        } else {
            System.out.println("Invalid ISBN 13 number");
            return false;
        }
    }

    public boolean setTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Title is null nad empty");
            return false;
        } else {
            this.title = title;
            return true;
        }
    }

    public boolean setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = Arrays.stream(author.split("[,\\s]+"))
                    .filter(s -> !s.isBlank())
                    .map(String::trim)
                    .toArray(String[]::new);
            return true;
        } else {
            System.out.println("Author list must have at least one name!");
            return false;
        }
    }

    public boolean setPublisher(String publisher) {
        if (publisher == null || publisher.isEmpty()) {
            System.out.println("Publisher is empty!");
            return false;
        } else {
            this.publisher = publisher;
            return true;
        }
    }

    public boolean setPublicationYear(String publicationYear) {
        int currentYear = Year.now().getValue(); //gets the actual current year
        try {
            int year = Integer.parseInt(publicationYear);
            if(year >= 1500 && year <= currentYear){
                this.publicationYear = year;
                return true;
            }else{
                throw new NumberFormatException("");
            }
        }catch (NumberFormatException e){
            System.out.println("Invalid publication year Must be between 1500 and " + currentYear + "!");
            return false;
        }
    }

    public boolean setLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            this.language = language;
            return true;
        } else {
            System.out.println("Language cannot be empty!");
            return false;
        }
    }

    public boolean validateAvailable(String inputChoice) {
        if(inputChoice != null && inputChoice.matches("(?i)^(yes|no)$")) {
            setAvailable(inputChoice.equalsIgnoreCase("yes"));
            return true;
        } else {
            System.out.println("Invalid Choice");
            return false;
        }
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public boolean setFormat(String format) {
        if(format != null && format.matches("^[A-Za-z ]+$")){
            this.format = format;
            return true;
        }else{
            System.out.println("Invalid Format");
            return false;
        }
    }

    public boolean setPageCount(String inputPageCount) {
        try {
            int pageCount = Integer.parseInt(inputPageCount);
            if(pageCount > 0) {
                this.pageCount = pageCount;
                return true;
            }else{
                throw new NumberFormatException("");
            }
        }catch (NumberFormatException e){
            System.out.println("Page count must be greater than zero!");
            return false;
        }
    }

    public boolean setDescription(String description) {
        if(description != null && !description.isEmpty()) {
            this.description = description;
            return true;
        }else{
            System.out.println("Description cannot be empty!");
            return false;
        }
    }

    public boolean setEditor(String editor) {

        if(editor != null && !editor.isEmpty()) {
            this.editor =  Arrays.stream(editor.split("[,\\s]+"))
                    .filter(s -> !s.isBlank())
                    .map(String::trim)
                    .toArray(String[]::new);;
            return true;
        }else{
            System.out.println("Editor list must have at least one name!");
            return false;
        }
    }

    public boolean setSubject(String subject) {

        if(subject != null && !subject.isEmpty()) {
            this.subject = subject;
            return true;
        }else{
            System.out.println("Subject cannot be empty!");
            return false;
        }
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    //Behavioral Methods
    public void markAvailable() {
        this.available = true;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public String getPrimaryEditor() {
        return editor[0];
    }

    public String getDetails() {
        return "Format: "+ format+", Pages: "+ pageCount + ", Subject: "+ subject+", Primary Editor: "+ getPrimaryEditor();
    }

    public BookItem getBookItem() {
        return bookItem;
    }
    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }
}

