package dao;
import hib_entities.*; // Books and Authors class imported
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public static Authors getAuthor(String author_name) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Authors where name = ?1", hib_entities.Authors.class);
        query.setParameter(1, author_name);
        List<Authors> authors = query.getResultList();
        Authors author = authors.getFirst(); // unique authors in authors table


        tx.commit();
        session.close();

        return author;

    }

}
