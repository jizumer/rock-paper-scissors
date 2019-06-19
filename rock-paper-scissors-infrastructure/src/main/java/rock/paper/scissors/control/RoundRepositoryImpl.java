package rock.paper.scissors.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.params.UserCriteria;

@Singleton
public class RoundRepositoryImpl implements RoundRepository {

    private Map<String, List<Round>> roundsData;
    private Totals totals;

    @Inject
    public RoundRepositoryImpl() {
        roundsData = new HashMap<>();
        totals = new Totals();
    }

    @Override
    public Round create(final Round round) {
        throw new UnsupportedOperationException("Not coded yet");
    }

    @Override
    public List<Round> findByUser(final UserCriteria criteria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Round findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void restart(String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Totals getTotals() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
