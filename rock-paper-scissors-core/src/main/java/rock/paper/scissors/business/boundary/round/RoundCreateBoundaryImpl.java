package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.entity.Round;

public class RoundCreateBoundaryImpl
        implements RoundCreateBoundary<Round> {

    private RoundControl roundControl;

    public RoundCreateBoundaryImpl(final RoundControl intervencionContr) {
        roundControl = intervencionContr;
    }

    @Override
    public Round create(final Round round) {
        return roundControl.create(round);
    }

}
