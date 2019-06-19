package rock.paper.scissors.control;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;

@Singleton
public class RoundRepositoryImpl implements RoundRepository {


    @Inject
    public RoundRepositoryImpl() {
        //No-arg constructor
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

}
