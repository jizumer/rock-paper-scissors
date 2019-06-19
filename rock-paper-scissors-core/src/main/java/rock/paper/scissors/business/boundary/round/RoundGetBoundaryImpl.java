package rock.paper.scissors.business.boundary.round;

import java.util.List;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundGetBoundaryImpl implements RoundGetBoundary<List<Round>> {

    private final RoundRepository roundRepository;

    public RoundGetBoundaryImpl(final RoundRepository repository) {
        roundRepository = repository;
    }

    @Override
    public List<Round> findByUser(final UserCriteria criteria) {
        return roundRepository.findByUser(criteria);
    }

}
