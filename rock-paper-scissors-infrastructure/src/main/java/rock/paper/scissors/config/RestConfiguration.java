package rock.paper.scissors.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value = RestConfiguration.PATH_REST)
public class RestConfiguration extends Application {

    public static final String PATH_REST = "api";
    public static final String PATH_VERSION = "v1";

    public RestConfiguration() {
        //Default configuration
    }
}
