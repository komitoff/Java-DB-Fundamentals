package game_store.modelParser;

import org.modelmapper.ModelMapper;

public class ModelParser {
    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
