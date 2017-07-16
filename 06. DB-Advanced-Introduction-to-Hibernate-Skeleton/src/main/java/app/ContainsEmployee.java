package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String[] tokens = name.split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee AS e ")
                .getResultList();
        boolean contains = false;

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
              contains = true;
            }
        }

        if (contains) {
            System.out.println(String.format("%s %s Yes", firstName, lastName));
        } else {
            System.out.println(String.format("%s %s No", firstName, lastName));
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
