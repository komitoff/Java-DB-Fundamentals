package application.service.user;

import application.entity.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public void persist(User user) {
        this.userRepository.saveAndFlush(user);
    }
}
