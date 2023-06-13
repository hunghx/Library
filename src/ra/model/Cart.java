package ra.model;

import java.util.Date;

public class Cart {
    private int id;
    private String bookName;
    private double bookPrice;
    private  String bookAuthor;
    private  int quantity;
    private String categoryName;
    private Date borrowedDate;
    private Date dueDate;

    public Cart() {
    }

    public Cart(int id, String bookName, double bookPrice, String bookAuthor, int quantity, String categoryName, Date borrowedDate, Date dueDate) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "------------------------------------------------------------\n" +
                "ID: "+ id + " | Name: "+ bookName+ "|Author: "+bookAuthor+
                "\nPrice: "+bookPrice + " | quantity: "+quantity+
                "\nBorrowedDate: "+borrowedDate + "| DueDate:"+dueDate;
    }
}
