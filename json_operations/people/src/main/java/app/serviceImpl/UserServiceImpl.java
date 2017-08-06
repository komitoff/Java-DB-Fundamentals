package app.serviceImpl;

import app.domain.dto.binding.UserDto;
import app.domain.dto.binding.add.UserAddDto;
import app.domain.model.User;
import app.io.ModelParser;
import app.repository.impl.UserRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserAddDto userJsonDto) {
        User user = ModelParser.getInstance().map(userJsonDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = ModelParser.getInstance().map(user, UserDto.class);
            userDtos.add(userDto);
        }

        return userDtos;
    }
}
