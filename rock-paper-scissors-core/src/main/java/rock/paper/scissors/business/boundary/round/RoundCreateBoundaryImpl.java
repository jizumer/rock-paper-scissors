package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.exception.RpsException;

public class RoundCreateBoundaryImpl
        implements RoundCreateBoundary<Round> {

    private RoundControl roundControl;

    public RoundCreateBoundaryImpl(final RoundControl roundContr) {
        roundControl = roundContr;
    }

    @Override
    public Round create(final String userId) throws RpsException{
        return roundControl.create(userId);
    }

}
