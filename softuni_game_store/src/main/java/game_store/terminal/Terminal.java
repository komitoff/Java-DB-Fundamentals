package game_store.terminal;

import game_store.CommandFactory;
import game_store.command.Executable;
import game_store.entity.User;
import game_store.service.GameService;
import game_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
public class Terminal implements CommandLineRunner{

    private UserService userService;
    private GameService gameService;

    @Autowired
    public Terminal(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... strings) throws Exception {
        CommandFactory commandFactory = new CommandFactory(this.userService, this.gameService);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = reader.readLine();
            if(line.equals("end")) {
                break;
            }

            String[] params = line.split("\\|");
            String command = params[0];
            String[] newParams = new String[params.length - 2];
            if (params.length > 1) {
                newParams = Arrays.copyOfRange(params, 1, params.length);
            }

            Executable executable = commandFactory.getCommand(command);
            String result = executable.execute(newParams);
            System.out.println(result);
        }

    }
}
