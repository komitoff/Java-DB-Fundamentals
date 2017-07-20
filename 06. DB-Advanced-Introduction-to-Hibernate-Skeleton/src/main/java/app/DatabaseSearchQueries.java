package app;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DatabaseSearchQueries {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query =  entityManager
                .createQuery("SELECT a FROM Address AS a " +
                            "ORDER BY a.employees.size DESC, " +
                            "a.town.name ASC");
        List<Address> addresses = query.setMaxResults(10).getResultList();


        for (Address address : addresses) {
            System.out.println(String.format("%s, %s - %d employees",
                    address.getText(),
                    address.getTown(),
                    address.getEmployees().size()));
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
