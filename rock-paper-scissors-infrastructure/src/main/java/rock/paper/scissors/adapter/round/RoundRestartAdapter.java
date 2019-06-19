package rock.paper.scissors.adapter.round;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rock.paper.scissors.business.boundary.round.RoundRestartBoundary;
import rock.paper.scissors.common.params.UserCriteria;
import rock.paper.scissors.config.RestConfiguration;

@RequestScoped
@Path(value = RestConfiguration.PATH_VERSION)
public class RoundRestartAdapter {

    private RoundRestartBoundary roundBundary;

    public RoundRestartAdapter() {
        //Default constructor
    }

    @Inject
    public RoundRestartAdapter(
            @Named("round-restart-infrastructure")
            final RoundRestartBoundary roundBoundary) {
        this.roundBundary = roundBoundary;
    }

    @Path("/{userId}/rounds/restart")
    @Produces({MediaType.APPLICATION_JSON})
    @PUT
    public void restart(@PathParam("userId") final String userId) {
        roundBundary.restart(new UserCriteria(userId));
    }

}
