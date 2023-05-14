package bookstore.api.v1.Model;

import java.util.Date;
import java.util.Scanner;

public class Book {
    private String id;
    private String title;
    private String author;
    private double price;
    private Date releaseDate;
    private int stock;
    private boolean availability;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int year, int month, int day) {
        Date temp = new Date(year, month, day);
        releaseDate = temp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getAvailability() {
        if (this.stock <= 0)
            return false;
        return availability;
    }

    public void setAvailability() {
        if (this.stock <= 0)
            this.availability = false;
        else
            this.availability = true;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void generate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the book id:");
        String id = scanner.nextLine();
        this.id = id;
        System.out.println("Please enter the book title:");
        String title = scanner.nextLine();
        this.title = title;

        System.out.println("Please enter the book author:");
        String author = scanner.nextLine();
        this.author = author;

        System.out.println("Please enter the book price:");
        double price = scanner.nextDouble();
        this.price = price;

        System.out.println("Please enter the book release date year:");
        int year = scanner.nextInt();
        System.out.println("Please enter the book release date month:");
        int month = scanner.nextInt();
        System.out.println("Please enter the book release date day:");
        int day = scanner.nextInt();
        Date theDate = new Date(year, month, day);
        this.releaseDate = theDate;

        System.out.println("Please enter the book stock:");
        int stock = scanner.nextInt();
        this.stock = stock;
        setAvailability();

    }

}
