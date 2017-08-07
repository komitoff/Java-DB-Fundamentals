package cars;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarDealerMain {
    public static void main(String[] args) {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, CarDealerMain.class);
        SpringApplication app = new SpringApplication(CarDealerMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
