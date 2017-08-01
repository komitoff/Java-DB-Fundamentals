package game_store.terminal;

import game_store.service.GameService;
import game_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... strings) throws Exception {

    }
}
