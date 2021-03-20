package startup.config;

import controller.ShashankController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ShashankApplication extends Application<ShashankConfig> {
    public static void main(String[] args) throws Exception {
        new ShashankApplication().run(args);
    }

    public void run(ShashankConfig shashankConfig, Environment environment) throws Exception {
        final ShashankController shashankController = new ShashankController(
                shashankConfig.getTemplate(),
                shashankConfig.getDefaultName()
        );

        environment.jersey().register(shashankController);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ShashankConfig> bootstrap) {
        // nothing to do yet
    }
}
