package rock.paper.scissors.business.boundary.round;

import java.util.List;
import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundGetBoundaryImpl implements RoundGetBoundary<List<Round>> {

    private RoundControl roundControl;

    public RoundGetBoundaryImpl(final RoundControl roundContr) {
        roundControl = roundContr;
    }

    @Override
    public List<Round> findByUser(final UserCriteria criteria) {
        return roundControl.findByUser(criteria.getUserId());
    }

}
