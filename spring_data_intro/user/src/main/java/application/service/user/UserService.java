package application.service.user;

import application.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findOne(long id);
    void persist(User user);
}
