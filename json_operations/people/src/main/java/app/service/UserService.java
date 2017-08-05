package app.service;

import app.domain.dto.binding.UserDto;
import app.domain.dto.binding.add.UserAddDto;

import java.util.List;


public interface UserService {
    void save(UserAddDto userJsonDto);
    List<UserDto> findAll();
}
