package app;

import entities.Address;
import entities.Employee;
import org.hibernate.boot.model.source.spi.EmbeddableMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddingNewAddres {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Address vitoshka = new Address();
        vitoshka.setText("Vitoshka 15");

        entityManager.persist(vitoshka);

        Employee employee = (Employee) entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'")
                .getSingleResult();
        employee.getAddress().setText(vitoshka.getText());
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
