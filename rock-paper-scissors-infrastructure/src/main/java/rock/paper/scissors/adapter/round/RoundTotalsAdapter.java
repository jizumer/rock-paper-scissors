package rock.paper.scissors.adapter.round;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rock.paper.scissors.business.boundary.round.RoundTotalsBoundary;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.config.RestConfiguration;

@RequestScoped
@Path(value = RestConfiguration.PATH_VERSION)
public class RoundTotalsAdapter {

    private RoundTotalsBoundary roundBundary;

    public RoundTotalsAdapter() {
        //Default constructor
    }

    @Inject
    public RoundTotalsAdapter(
            @Named("round-totals-infrastructure")
            final RoundTotalsBoundary roundBoundary) {
        this.roundBundary = roundBoundary;
    }

    @Path("/rounds/totals")
    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public Totals getTotals() {
        return roundBundary.getTotals();
    }

}
