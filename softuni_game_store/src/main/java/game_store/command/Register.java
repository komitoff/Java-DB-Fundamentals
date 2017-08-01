package game_store.command;

import game_store.service.GameService;
import game_store.service.UserService;

/**
 * Created by tobieski on 8/1/2017.
 */
public class Register extends Command {
    
    protected Register(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        return null;
    }
}
