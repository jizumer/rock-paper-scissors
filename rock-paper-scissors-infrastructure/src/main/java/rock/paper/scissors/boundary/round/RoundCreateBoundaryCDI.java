package rock.paper.scissors.boundary.round;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import rock.paper.scissors.business.boundary.round.RoundCreateBoundary;
import rock.paper.scissors.business.boundary.round.RoundCreateBoundaryImpl;
import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.entity.Round;


@Singleton
@Named("round-create-infrastructure")
public class RoundCreateBoundaryCDI extends RoundCreateBoundaryImpl
        implements RoundCreateBoundary<Round> {

    @Inject
    public RoundCreateBoundaryCDI(final RoundControl intervencionControl) {
        super(intervencionControl);
    }

    @Override
    public Round create(final Round round) {
        return super.create(round);
    }

}
