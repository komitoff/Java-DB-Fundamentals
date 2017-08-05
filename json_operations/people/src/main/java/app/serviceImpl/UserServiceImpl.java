package app.serviceImpl;

import app.domain.dto.json.UserJsonDto;
import app.domain.model.User;
import app.io.ModelParser;
import app.repository.impl.UserRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserJsonDto userJsonDto) {
        User user = ModelParser.getInstance().map(userJsonDto, User.class);
        this.userRepository.save(user);
    }
}
