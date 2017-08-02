package game_store.serviceImpl;

import game_store.entity.User;
import game_store.entity.enums.Role;
import game_store.model.bindingModel.user.RegisterUser;
import game_store.modelParser.ModelParser;
import game_store.repository.UserRepository;
import game_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void persist(RegisterUser registerUser) {
        User user = ModelParser.getInstance().map(registerUser, User.class);
        if (this.userRepository.findAll().size() > 0) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }
        this.userRepository.save(user);
    }
}
