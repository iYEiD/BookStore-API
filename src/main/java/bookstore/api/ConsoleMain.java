package bookstore.api;

import java.util.Scanner;

import bookstore.api.v1.Controller.BookController;
import bookstore.api.v1.Model.Book;

public class ConsoleMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Bookstore Console.");
        System.out.println("Please pick the option you want to perform:");
        System.out.println("1. Add a book");
        System.out.println("2. Update a book");
        System.out.println("3. Delete a book");
        System.out.println("4. Search for a book");
        System.out.println("5. Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        BookController bookController = new BookController();

        if (option == 1) {
            Book book = new Book();
            book.generate();
            bookController.addBook(book);
        }

        else if (option == 2) {
            System.out.println("Please enter the id of the book you want to update:");
            String id = scanner.next();
            Book book = new Book();
            book.generate();
            bookController.updateBook(id, book);
        }

        else if (option == 3) {
            System.out.println("Pick an option: \n1. Delete by id \n2. Delete all");
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Please enter the id of the book you want to delete:");
                String id = scanner.next();
                bookController.deleteBook(id);
            } else if (option == 2) {
                bookController.deleteAllBooks();
            } else {
                System.out.println("Invalid option.");
            }
        }

        else if (option == 4) {
            System.out.println("Pick an option: \n1. Search by id \n2. Search by title \n3. Search by author");
            option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Please enter the id of the book you want to search:");
                String id = scanner.next();
                bookController.getBookById(id);
            } else if (option == 2) {
                System.out.println("Please enter the title of the book you want to search:");
                String title = scanner.next();
                bookController.searchBooksTitled(title);
            }

            else if (option == 3) {
                System.out.println("Please enter the author of the book you want to search:");
                String author = scanner.next();
                bookController.searchBooksAuthored(author);
            }

            else {
                System.out.println("Invalid option.");
            }
        }

        else if (option == 5) {
            System.out.println("Thank you for using Bookstore Console.");
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}