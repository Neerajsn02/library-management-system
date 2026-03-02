package dao;
import hib_entities.*; // Books and Authors class imported
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


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

    public static Books getBook(String name) {
        Session session = sf.openSession();
        Query query = session.createQuery("from Books where book_name = ?1", hib_entities.Books.class);
        query.setParameter(1, name);
        List<Books> books = query.getResultList();
        session.close();
        return books.getFirst();
    }

}
