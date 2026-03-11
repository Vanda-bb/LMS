import java.util.Date;

public class BookItem {
    private int bookItemId;
    private String isbn13;
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowedDate;
    private Date dueDate;
    private double price;
    private Status status;
    private String locationShelf;

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
        if (isReferenceOnly == true) {
            System.out.println("The book cannot be checkout");
            this.isReferenceOnly = false;
        } else {
            this.isReferenceOnly = true;
        }

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
    public void checkout(String userID) {
        this.status = Status.LOANED;
        this.dueDate = new Date();

    }

    public void returnItem() {
        this.status = Status.AVAILABLE;
        this.dueDate = null;
    }

    public void renew() {
        this.dueDate = null;


    }

    public void updateStatus(String newStatus) {
        this.status = Status.valueOf(newStatus);
    }
}
