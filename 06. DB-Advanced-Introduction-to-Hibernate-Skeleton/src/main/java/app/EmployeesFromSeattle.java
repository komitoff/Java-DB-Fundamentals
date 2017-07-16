package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesFromSeattle {

    public static void run() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, " +
                        "e.firstName DESC");
        List<Employee> employeeList = query.getResultList();

        for (Employee employee : employeeList) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
