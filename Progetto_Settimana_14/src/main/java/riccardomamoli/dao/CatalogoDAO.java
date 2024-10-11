package riccardomamoli.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardomamoli.entities.Libro;
import riccardomamoli.entities.elementoBaseCatalogo;
import riccardomamoli.exceptions.NotFoundException;

import java.util.UUID;

public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveElement(elementoBaseCatalogo elementoBaseCatalogo){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoBaseCatalogo);
        transaction.commit();
        System.out.println("L'elemento " + elementoBaseCatalogo.getTitolo() + " è stato salvato correttamente.");
    }

    public elementoBaseCatalogo findById(UUID ISBN) {
        elementoBaseCatalogo elementFound = entityManager.find(elementoBaseCatalogo.class, ISBN);
        if (elementFound == null) throw new NotFoundException(ISBN);
        return elementFound;
    }

    public void findElementAndDelete(UUID ISBN) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        elementoBaseCatalogo elemento = findById(ISBN);
        entityManager.remove(elemento);
        transaction.commit();
        System.out.println(elemento + "cancellato con successo!");
    }



}
