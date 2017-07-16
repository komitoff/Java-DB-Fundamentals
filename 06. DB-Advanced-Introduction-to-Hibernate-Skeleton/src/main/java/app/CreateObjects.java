package app;

import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by tobieski on 7/16/2017.
 */
public class CreateObjects {

    public CreateObjects(){}

    public static void run() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();

        //Get random employee (id = 1)
        Employee manager = (Employee) entityManager.createQuery(
                "SELECT e FROM Employee AS e WHERE e.id=1")
                .getSingleResult();

        //Create new department
        Department training = new Department();
        training.setManager(manager);
        training.setName("Training");

        //Create new town
        Town burgas = new Town();
        burgas.setName("Burgas");

        //Create new adresses in Burgas
        Address addressOne = new Address();
        addressOne.setTown(burgas);
        addressOne.setText("Qvor");

        Address addressTwo = new Address();
        addressTwo.setTown(burgas);
        addressTwo.setText("Gushlovica");

        Address addressThree = new Address();
        addressThree.setTown(burgas);
        addressThree.setText("Neshtositam");

        //Create few employees
        Employee ivan = new Employee();
        ivan.setAddress(addressOne);
        ivan.setDepartment(training);
        ivan.setFirstName("Ivan");
        ivan.setJobTitle("Java developer");
        ivan.setLastName("Geshev");
        ivan.setManager(manager);
        ivan.setSalary(new BigDecimal(2555));
        Date ivanHireDate = new Date();
        ivan.setHireDate(new Timestamp(ivanHireDate.getTime()));

        Employee pesho = new Employee();
        pesho.setAddress(addressTwo);
        pesho.setDepartment(training);
        pesho.setFirstName("Pesho");
        pesho.setJobTitle("C# developer");
        pesho.setLastName("Georgiev");
        pesho.setManager(manager);
        pesho.setSalary(new BigDecimal(14223));
        Date peshoHireDate = new Date();
        pesho.setHireDate(new Timestamp(peshoHireDate.getTime()));

        Employee gosho = new Employee();
        gosho.setAddress(addressThree);
        gosho.setDepartment(training);
        gosho.setFirstName("Gosho");
        gosho.setJobTitle("PHP developer");
        gosho.setLastName("Georgiev");
        gosho.setManager(manager);
        gosho.setSalary(new BigDecimal(2));
        Date goshoHireDate = new Date();
        gosho.setHireDate(new Timestamp(goshoHireDate.getTime()));

        entityManager.getTransaction().begin();
        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(addressOne);
        entityManager.persist(addressTwo);
        entityManager.persist(addressThree);
        entityManager.persist(pesho);
        entityManager.persist(ivan);
        entityManager.persist(gosho);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }
}
