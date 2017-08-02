package game_store.command;

import game_store.model.bindingModel.user.RegisterUser;
import game_store.service.GameService;
import game_store.service.UserService;
import game_store.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.krb5.internal.PAData;

public class Register extends Command {

    public Register(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(params[0]);
        registerUser.setPassword(params[1]);
        registerUser.setConfirmPassword(params[2]);
        registerUser.setFullName(params[3]);

        if (!DataValidator.isValid(registerUser)) {
            return DataValidator.getInvalidParameterMessage(registerUser);
        }
        try {
            super.getUserService().persist(registerUser);
        } catch (Exception e) {
            return e.getMessage();
        }


        return String.format("%s was registered", params[3]);
    }
}
