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

        Authors a1 = new Authors();
        a1.setAuthor_id(1);
        a1.setName("Rick Riordan");

        Books b1 = new Books();
        b1.setBook_id(1);
        b1.setBook_name("Percy Jackson - Lightning Thief");
        b1.setAuthor(a1);
        b1.setBook_qty(4);

        Books b2 = new Books();
        b2.setBook_id(2);
        b2.setBook_name("Percy Jackson - Sea of Monsters");
        b2.setAuthor(a1);
        b2.setBook_qty(3);

        a1.setBooks(Arrays.asList(b1, b2));

        AuthorDao.saveAuthor(a1);
        BookDao.saveBook(b1);
        BookDao.saveBook(b2);








    }

}
