package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeesSalary {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager
                .createQuery("SELECT e.firstName " +
                                "FROM Employee AS e " +
                                "WHERE salary > 50000");
        List<String> employeesNames = query.getResultList();

        for (String employeeName : employeesNames) {
            System.out.println(employeeName);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
