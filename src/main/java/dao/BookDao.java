package dao;
import hib_entities.*; // Books and Authors class imported
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class BookDao {

    private static SessionFactory sf;

    // pass sf from main while building the object
    public BookDao(SessionFactory sf) {
        BookDao.sf = sf;
    }

    public static void saveBook(Books book) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);
        System.out.println("Successfully added book to Books!");

        tx.commit();
        session.close();
    }

}
