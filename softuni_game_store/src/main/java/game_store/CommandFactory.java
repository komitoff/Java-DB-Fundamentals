package game_store;

import game_store.command.Executable;
import game_store.command.Register;
import game_store.service.GameService;
import game_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandFactory {

    private UserService userService;
    private GameService gameService;

    @Autowired
    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable getCommand(String command) {

        switch (command) {
            case "Register":
                return new Register(this.userService, this.gameService);
            default: return null;
        }
    }
}
