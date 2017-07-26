package application.terminal;

import application.entity.User;
import application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
//        seedUser();
        List<User> abvUsers = userService.findByEmailProvider("abv.bg");
        abvUsers
                .stream()
                .forEach(x -> System.out.println(x.getUsername() + " -> " + x.getEmail()));
        System.out.println("size: " + abvUsers.size());
    }

    public void seedUser() {
        User user = new User();
        user.setUsername("username");
        user.setAge(21);
        user.setDeleted(false);
        user.setEmail("user@abv.bg");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1991, 12, 19);
        Date lastLogged = calendar.getTime();
        calendar.set(2001,12,12);
        Date registeredOn = calendar.getTime();
        user.setLastTimeLoggedIn(lastLogged);
        user.setRegisteredOn(registeredOn);
        user.setPassword("A1a98s@@s1515");
        userService.persist(user);
    }
}
