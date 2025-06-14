package  model;
import java.util.ArrayList;
public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBooksId=new ArrayList<>();

    //constructor
    public User(int userId, String name, String username, String password, boolean isAdmin) {
        this.userId = userId;
        this.name = name;
        this.username=username;
        this.password=password;
        this.isAdmin=isAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void borrowBook(int bookId){
        borrowedBooksId.add(bookId);
    }
    public void returnBook(int bookId){
        borrowedBooksId.remove(bookId);
    }

    public void ShowBorrowedBooks(){
        if(borrowedBooksId.isEmpty()){
            System.out.println("You have no borrowed books");
        }else{
            System.out.println("Borrowed Books Id: "+ borrowedBooksId);
        }
    }
 

}
