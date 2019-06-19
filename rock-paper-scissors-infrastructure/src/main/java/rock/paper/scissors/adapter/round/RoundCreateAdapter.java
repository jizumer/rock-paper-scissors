package rock.paper.scissors.adapter.round;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rock.paper.scissors.business.boundary.round.RoundCreateBoundary;
import rock.paper.scissors.business.entity.Round;

@RequestScoped
public class RoundCreateAdapter {

    RoundCreateBoundary<Round> roundBoundary;

    public RoundCreateAdapter() {
        // Default constructor
    }

    @Inject
    public RoundCreateAdapter(
            @Named("round-create-infrastructure")
            final RoundCreateBoundary<Round> roundBoundary) {
        this.roundBoundary = roundBoundary;
    }

    @Path("/{userId}/rounds")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @POST
    public Round create(@PathParam("userId") final String userId, final Round inputRound) {
        // Validations
        validate(userId, inputRound);

        return roundBoundary.create(inputRound);
    }

    private void validate(final String userId, final Round inputRound) {
        //TODO: Implement validations

    }

}
