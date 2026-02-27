package dao;
import hib_entities.*; // Books and Authors class imported
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AuthorDao {

    private static SessionFactory sf;

    public AuthorDao(SessionFactory sf) {
        AuthorDao.sf = sf;
    }

    public static void saveAuthor(Authors author) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(author);

        tx.commit();
        session.close();
    }

}
