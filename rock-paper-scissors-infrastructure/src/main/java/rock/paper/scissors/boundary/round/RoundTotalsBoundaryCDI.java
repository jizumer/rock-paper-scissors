package rock.paper.scissors.boundary.round;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import rock.paper.scissors.business.boundary.round.RoundTotalsBoundary;
import rock.paper.scissors.business.boundary.round.RoundTotalsBoundaryImpl;
import rock.paper.scissors.business.control.RoundControl;

@Singleton
@Named("round-totals-infrastructure")
public class RoundTotalsBoundaryCDI extends RoundTotalsBoundaryImpl
        implements RoundTotalsBoundary {

    @Inject
    public RoundTotalsBoundaryCDI(final RoundControl control) {
        super(control);
    }

}
