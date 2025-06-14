package manager;

import java.util.*;
import model.Book;
import model.User;



public class LibraryManager {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void addUser(User u) {
        users.add(u);
    }

    // viewallBooks
    public void viewAllBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // getAllUsers
    public ArrayList<User> getAllUsers() {
        return users;
    }

    // getBookById
    public Book getBookById(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        return null;
    }

    // getUserById
    public User getUserById(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) {
                return u;
            }
        }
        return null;
    }

    // searchBookBykeyword
    public void searchBookByTitle(String t) {
        boolean notFound = true;
        String title = t.toLowerCase();
        for (Book b : books) {
            String bookTitle = b.getTitle().toLowerCase();
            if (bookTitle.contains(title)) {
                System.out.println(b);
                notFound = false;
            }
        }
        if (notFound) {
            System.out.println("No books found");
        }

    }

    public void borrowBook(int bookId, int userId) {
        Book b = getBookById(bookId);
        User u = getUserById(userId);
        if (b != null && u != null && b.getAvailableCopies() > 0) {
            b.decreaseCopies();
            u.borrowBook(bookId);
            System.out.println("Book borrowed Successfully");
        } else {
            System.out.println("Unable to Borrow Book");
        }
    }

    // returnBook
    public void returnBook(int bookId, int userId) {
        Book b = getBookById(bookId);
        User u = getUserById(userId);
        if (b != null && u != null) {
            b.increaseCopies();
            u.returnBook(bookId);
            System.out.println("Book returned Successfully");
        } else {
            System.out.println("Unable to Return Book");
        }
    }

}
