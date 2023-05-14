package bookstore.api;

import java.util.Scanner;

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
    if(option == 1){

    }
    else if(option == 2){

    }
    else if(option == 3){

    }
    else if(option == 4){

    }
    else if(option == 5){
        System.out.println("Thank you for using Bookstore Console.");
    }
    else{
        System.out.println("Invalid option. Please try again.");
    }
}
}