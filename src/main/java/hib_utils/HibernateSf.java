package hib_utils;

import org.hibernate.SessionFactory;
import dao.Authors;
import dao.Books;
import org.hibernate.cfg.Configuration;

public class HibernateSf {

    final private static SessionFactory sf = new Configuration()
            .addAnnotatedClass(Authors.class)
            .addAnnotatedClass(Books.class)
            .configure()
            .buildSessionFactory();

    public static SessionFactory getSession() {
        return sf;
    }

    public static void closeSession() {
        sf.close();
    }

}
