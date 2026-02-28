import dao.AuthorDao;
import dao.BookDao;
import hib_entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hib_utils.HibernateSf;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

// Book and Authors define and build the objects that need to be saved
// Bookdao and authorsdao will do the actual work of persisting/getting from db

public class Main {

    public static void main(String[] args) {

        SessionFactory sf = HibernateSf.getSession(); //pass this to Dao objects

        new BookDao(sf);
        new AuthorDao(sf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter operation [ save | get | update | exit ] - ");
        String operation = sc.nextLine();

        if (operation.equals("save")) {
            System.out.println("Enter save operation - [ save-book | save-author ]");
            String subOperation = sc.nextLine();
            if (subOperation.equals("save-book")) {
                saveBook(sc);



            }
        }




    }

    public static void saveBook(Scanner sc) {
        Books book = new Books();
        System.out.println("book name - ");
        book.setBook_name(sc.nextLine());
        System.out.println("book id - ");
        book.setBook_id(sc.nextInt());
        sc.nextLine(); // newLine character still in buffer
        System.out.println("Author name - ");
        String authName = sc.nextLine();

        // check if author exists in database - return the author object from authors table
        // use authordao

        Authors author = AuthorDao.getAuthor(authName);
        book.setAuthor(author);

        // NEED TO ADD - IF AUTHOR DOESN'T EXIST, PROMPT OR SOMETHING TO CREATE AN AUTHOR FIRST

        System.out.println("Enter quantity - ");
        book.setBook_qty(sc.nextInt());

        BookDao.saveBook(book);



    }

}
