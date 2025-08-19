// Driver.java
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Driver {
    private static List<Book> books;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("Loading Amazon Bestselling Books Dataset...");
        books = DatasetReader.readDataset("data/data.csv");
        
        if (books.isEmpty()) {
            System.err.println("No books loaded. Please check if 'data.csv' exists and is properly formatted.");
            return;
        }
        
        System.out.println("Successfully loaded " + books.size() + " books from the dataset.\n");
        
      
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    handleTotalBooksByAuthor();
                    break;
                case 2:
                    handleAllAuthors();
                    break;
                case 3:
                    handleBooksByAuthor();
                    break;
                case 4:
                    handleBooksByRating();
                    break;
                case 5:
                    handleBooksPricesByAuthor();
                    break;
                case 6:
                    displayAllBooks();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using the Amazon Books Dataset application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Amazon Bestselling Books Dataset Analysis");
        System.out.println("=".repeat(50));
        System.out.println("1. Get total number of books by an author");
        System.out.println("2. Display all authors in the dataset");
        System.out.println("3. Get all books by an author");
        System.out.println("4. Get books by user rating");
        System.out.println("5. Get book prices by author");
        System.out.println("6. Display all books in dataset");
        System.out.println("7. Exit");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-7): ");
    }
    
    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void handleTotalBooksByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        int count = BookAnalyzer.getTotalBooksByAuthor(authorName, books);
        System.out.println("\nResult:");
        System.out.println("Author: " + authorName);
        System.out.println("Total books: " + count);
    }
    
    private static void handleAllAuthors() {
        BookAnalyzer.printAllAuthors(books);
    }
    
    private static void handleBooksByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        List<String> bookTitles = BookAnalyzer.getBooksByAuthor(authorName, books);
        
        System.out.println("\nBooks by " + authorName + ":");
        System.out.println("=".repeat(40));
        if (bookTitles.isEmpty()) {
            System.out.println("No books found for this author.");
        } else {
            for (int i = 0; i < bookTitles.size(); i++) {
                System.out.println((i + 1) + ". " + bookTitles.get(i));
            }
            System.out.println("\nTotal books found: " + bookTitles.size());
        }
    }
    
    private static void handleBooksByRating() {
        System.out.print("Enter user rating (e.g., 4.7): ");
        try {
            double rating = Double.parseDouble(scanner.nextLine().trim());
            
            List<Book> matchingBooks = BookAnalyzer.getBooksByRating(rating, books);
            
            System.out.println("\nBooks with rating " + rating + ":");
            System.out.println("=".repeat(40));
            if (matchingBooks.isEmpty()) {
                System.out.println("No books found with this rating.");
            } else {
                for (int i = 0; i < matchingBooks.size(); i++) {
                    Book book = matchingBooks.get(i);
                    System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
                }
                System.out.println("\nTotal books found: " + matchingBooks.size());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating format. Please enter a decimal number.");
        }
    }
    
    private static void handleBooksPricesByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        List<String> bookPrices = BookAnalyzer.getBooksAndPricesByAuthor(authorName, books);
        
        System.out.println("\nBooks and prices by " + authorName + ":");
        System.out.println("=".repeat(50));
        if (bookPrices.isEmpty()) {
            System.out.println("No books found for this author.");
        } else {
            for (int i = 0; i < bookPrices.size(); i++) {
                System.out.println((i + 1) + ". " + bookPrices.get(i));
            }
            System.out.println("\nTotal books found: " + bookPrices.size());
        }
    }
    
    private static void displayAllBooks() {
        System.out.println("\nAll Books in Dataset:");
        System.out.println("=".repeat(60));
        
        if (books.size() > 20) {
            System.out.println("Dataset contains " + books.size() + " books. Showing first 20:");
            System.out.println("=".repeat(60));
            for (int i = 0; i < 20; i++) {
                System.out.println((i + 1) + ". " + books.get(i).toString());
            }
            System.out.println("\n... and " + (books.size() - 20) + " more books.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i).toString());
            }
        }
    }
}