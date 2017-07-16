package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RefreshData {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = (Employee) entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = 4")
                .getSingleResult();
        employee.setFirstName(employee.getFirstName().toLowerCase());
        entityManager.refresh(employee);
        System.out.println(employee.getFirstName());
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
