package app.service;

import app.domain.dto.json.UserJsonDto;


public interface UserService {
    void save(UserJsonDto userJsonDto);
}
