package rock.paper.scissors.boundary.round;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import rock.paper.scissors.business.boundary.round.RoundRestartBoundary;
import rock.paper.scissors.business.boundary.round.RoundRestartBoundaryImpl;
import rock.paper.scissors.business.control.RoundControl;

@Singleton
@Named("round-restart-infrastructure")
public class RoundRestartBoundaryCDI extends RoundRestartBoundaryImpl
        implements RoundRestartBoundary {

    @Inject
    public RoundRestartBoundaryCDI(final RoundControl control) {
        super(control);
    }

}
