package rock.paper.scissors.config;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsRSFilter implements ContainerResponseFilter {

    /**
     * CORS
     */
    public CorsRSFilter() {
        //Empty constructor
    }

    /**
     * Writes Access-Control-Allow-Origin headers
     *
     */
    @Override
    public final void filter(final ContainerRequestContext request,
            final ContainerResponseContext response) throws IOException {

        // No cacheable headers
        // HTTP 1.1.
        response.getHeaders()
                .add("Cache-Control", "no-cache, no-store, must-revalidate");
        // HTTP 1.0.
        response.getHeaders().add("Pragma", "no-cache");
        // Proxies.
        response.getHeaders().add("Expires", 0);

        // Cors headers
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, MACO, version");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.getHeaders().add("Access-Control-Expose-Headers", "Location");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }

}
