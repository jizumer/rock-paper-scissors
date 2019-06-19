package rock.paper.scissors.business.control;

import java.util.List;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundControl {

    private RoundRepository roundRepository;

    public RoundControl(
            final RoundRepository intervencionRepository) {

        this.roundRepository = intervencionRepository;
    }

    public Round create(final String userId) {
        Round round = play(userId);
        return roundRepository.create(round);
    }

    public List<Round> findByUser(final String userId) {
        final UserCriteria criteria = new UserCriteria(userId);
        return roundRepository.findByUser(criteria);
    }

    public void restart(String userId) {
        roundRepository.restart(userId);
    }

    public Totals getTotals() {
        return roundRepository.getTotals();
    }

    /**
     * This method holds the core business logic of the game
     *
     * @param userId App user id. The round record will store this id.
     * @return The generated Round object.
     */
    private Round play(String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
