import java.util.Date;

public class BookItem{
    private int bookItemId;
    private String isbn13;
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowedDate;
    private Date dueDate;
    private double price;
    private Status status;
    private String locationShelf;

    //Non-default constructors
    public BookItem(
            int bookItemId,
            String isbn13,
            String barcode,
            Boolean isReferenceOnly,
            Date borrowedDate,
            Date dueDate,
            double price,
            Status status,
            String locationShelf
    ) {
        setBookItemId(bookItemId);
        setIsbn13(isbn13);
        setBarcode(barcode);
        setReferenceOnly(isReferenceOnly);
        setBorrowedDate(borrowedDate);
        setDueDate(dueDate);
        setPrice(price);
        setStatus(status);
        setLocationShelf(locationShelf);
    }

    //Getter
    public int getBookItemId() {
        return bookItemId;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public String getLocationShelf() {
        return locationShelf;
    }

    //Setter
    public void setBookItemId(int bookItemId) {
        this.bookItemId = bookItemId;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setReferenceOnly(boolean isReferenceOnly) {
        isReferenceOnly = isReferenceOnly;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLocationShelf(String locationShelf) {
        this.locationShelf = locationShelf;
    }

    //Behavioral Methods
    public void checkout(int userID) {
        this.bookItemId = userID;
        this.status = Status.LOANED;
        this.borrowedDate = new Date();

    }

    public void returnItem() {
        this.status = Status.AVAILABLE;
        this.dueDate = null;
        System.out.println("Book returned and is now available");
    }

    public void renew() {
        if(this.status == Status.LOANED && this.dueDate != null) {
            System.out.println("Book renewed. New due date: " + dueDate);
        }else{
            System.out.println("Book cannot be renewed");
        }


    }

    public void updateStatus(Status newStatus) {

        this.status = newStatus;
        System.out.println("Book status updated to: " + newStatus);
    }
}
