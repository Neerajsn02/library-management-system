import org.hibernate.SessionFactory;
import hib_utils.HibernateSf;

public class Main {

    public static void main(String[] args) {

        SessionFactory sf = HibernateSf.getSession();


    }

}
