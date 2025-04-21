//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    static Book[] books = new Book[20];


    public static void availableBooks() {
        System.out.println("\nAvailable:");
        for (Book b : books) { //
            if (b == null || b.isCheckedOut) { // If b is null (empty spot in the collection) or the book is checked out
                continue; // then it skips the current loop (No printing)
            }
            System.out.printf("ID: %d - %s, %s\n", b.id, b.title, b.isbn); // if the book is not null and not checked out, this line will be printed
        }
        String command = "enter"; // command is initialized to "enter" just to enter the while loop.
        Scanner in = new Scanner(System.in); // A Scanner object is created to read user input from the keyboard.
        while (!command.equalsIgnoreCase("X")) { // The loop continues until the user enters "X" (to exit).
            System.out.println(""" 
                    C - to check out a book,
                    X - to exist this screen
                    """); // The menu is printed
            command = in.next().trim();
            if (command.equalsIgnoreCase("X")) {
                return; // If the user entered "X", the function returns to wherever it was called from
            } else if (command.equalsIgnoreCase("C")) {
                System.out.println("Enter book ID: ");
                int id = in.nextInt(); // gets the ID
                in.nextLine(); // nextInt() reads the number, and nextLine() clears the buffer.
                for (Book b : books) {
                    if (b.id == id) {
                        System.out.println("Enter your name: ");
                        String name = in.nextLine().trim();
                        b.checkOut(name);
                        break;
                    }
                }
            }
        }
    }

    public static void CheckedOutBooks() {
        System.out.println("\nChecked Out:");
        boolean anyCheckedOut = false;

        for (Book b : books) {
            if (b != null && b.isCheckedOut) { //If b is not null ( not empty ) or the book is checked out
                System.out.printf("ID: %d - %s, %s - Checked out by: %s\n", b.getId(),b.getTitle(),b.getIsbn(), b.getCheckedOutBy()); // prints out the books that are checked out
                anyCheckedOut = true; // As soon it find a book thats checked out, anyCheckedOut becomes true
            }
        }

        if (!anyCheckedOut) { // After looking through all the book and no books are checked out
            System.out.println("No books are currently checked out.");// print this
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equalsIgnoreCase("X")) {
            System.out.println("""
                    C - to Check In a book
                    X - to go back to the home screen
                    """);
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("C")) {
                checkInBook(scanner);
                return;
            } else if (!command.equalsIgnoreCase("X")) {
                System.out.println("Invaild input. Please choose C or X.");
            }
        }


    }

    public static void checkInBook(Scanner scanner) {
        System.out.println("Enter the ID of the book to check in: ");

        int idToCheckIn = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (Book b : books) {
            if (b != null && b.getId() == idToCheckIn) {
                found = true;
                if (!b.isCheckedOut()) {
                    System.out.println("Book is Already Checked Out");
                } else {
                    b.checkIn();
                    System.out.println("Book is checked in successfully");
                }
                break; // if we found the book, no need to continue
            }
        }
        if (!found) {
            System.out.println("No book with that ID was found.");
        }
    }

    public static void main(String[] args) {

        books[0] = new Book(111, "978-0307292063", "Foundation");
        books[1] = new Book(222, "ASIN-B07D23CFGR", "Atomic Habits");
        books[2] = new Book(333, "978-0679728757", "Blood Meridian");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Store Home Screen ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    availableBooks();
                    break;
                case 2:
                    CheckedOutBooks();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thanks for using the library!!!");

    }
}