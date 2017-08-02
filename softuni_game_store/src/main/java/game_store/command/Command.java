package game_store.command;

import game_store.service.GameService;
import game_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Command implements Executable {

    private UserService userService;
    private GameService gameService;

    public Command(UserService userService, GameService gameService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public GameService getGameService() {
        return gameService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
