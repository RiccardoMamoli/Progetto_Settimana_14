package riccardomamoli;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import riccardomamoli.dao.CatalogoDAO;
import riccardomamoli.entities.Libro;
import riccardomamoli.entities.Periodicità;
import riccardomamoli.entities.Rivista;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_settimana_14");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);

        Libro libro1 = new Libro("Harry Potter", 2007, 1000, "JK. Rowling", "Fantasy");
        Libro libro2 = new Libro("1984", 1949, 328, "George Orwell", "Dystopian");
        Libro libro3 = new Libro("To Kill a Mockingbird", 1960, 281, "Harper Lee", "Historical Fiction");

        Rivista rivista1 = new Rivista("National Geographic", 2023, 50, Periodicità.MENSILE);
        Rivista rivista2 = new Rivista("Scientific American", 2023, 98, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista("Time", 2023, 60, Periodicità.SETTIMANALE);

        cd.saveElement(libro2);
        cd.saveElement(libro3);
        cd.saveElement(rivista2);
        cd.saveElement(rivista3);





        em.close();
        emf.close();
    }
}
