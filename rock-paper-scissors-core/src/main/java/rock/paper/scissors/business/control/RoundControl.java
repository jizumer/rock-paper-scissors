package rock.paper.scissors.business.control;

import java.util.List;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundControl {

    private RoundRepository roundRepository;

    public RoundControl(
            final RoundRepository intervencionRepository) {

        this.roundRepository = intervencionRepository;
    }

    public Round create(final Round round) {

        return roundRepository.create(round);
    }

    public List<Round> findByUser(final String userId) {
        final UserCriteria criteria = new UserCriteria(userId);
        return roundRepository.findByUser(criteria);
    }

}
