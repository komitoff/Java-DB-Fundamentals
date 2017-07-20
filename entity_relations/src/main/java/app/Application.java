package app;

import entity.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Antoich Peverel");
        dumbledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 10, 20);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(depositEnd);
        dumbledore.setDepositAmount(2000.24);
        dumbledore.setDepositCharge(0.2);
        dumbledore.setIsDepositExpired(false);

        entityManager.getTransaction().begin();
        entityManager.persist(dumbledore);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
