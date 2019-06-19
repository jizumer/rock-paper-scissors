package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundRestartBoundaryImpl implements RoundRestartBoundary {

    private RoundControl roundControl;

    public RoundRestartBoundaryImpl(final RoundControl roundContr) {
        roundControl = roundContr;
    }

    @Override
    public void restart(UserCriteria criteria) {
        roundControl.restart(criteria.getUserId());
    }

}
