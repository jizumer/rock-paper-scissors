package rock.paper.scissors.adapter.round;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rock.paper.scissors.business.boundary.round.RoundGetBoundary;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;
import rock.paper.scissors.config.RestConfiguration;

@RequestScoped
@Path(value = RestConfiguration.PATH_VERSION)
public class RoundGetAdapter {

    private RoundGetBoundary<List<Round>> roundBundary;

    public RoundGetAdapter() {
        //Default constructor
    }

    @Inject
    public RoundGetAdapter(
            @Named("round-get-infrastructure")
            final RoundGetBoundary<List<Round>> roundBoundary) {
        this.roundBundary = roundBoundary;
    }

    @Path("/{userId}/rounds")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public List<Round> findByUser(@PathParam("userId") final String userId) {
        return roundBundary.findByUser(new UserCriteria(userId));
    }

}
