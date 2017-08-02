package game_store.service;

import game_store.model.bindingModel.user.RegisterUser;

public interface UserService {
    void persist(RegisterUser registerUser);
}
