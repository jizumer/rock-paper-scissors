package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.entity.Totals;

public class RoundTotalsBoundaryImpl implements RoundTotalsBoundary {

    private RoundControl roundControl;

    public RoundTotalsBoundaryImpl(final RoundControl roundContr) {
        roundControl = roundContr;
    }

    @Override
    public Totals getTotals() {
        return roundControl.getTotals();
    }

}
