package rock.paper.scissors.control;

import java.util.ArrayList;
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

    private Map<String, List<Round>> rounds;
    private Totals totals;

    @Inject
    public RoundRepositoryImpl() {
        rounds = new HashMap<>();
        totals = new Totals();
    }

    /**
     * Creation entity method. It usually makes sense to return the created
     * object, since it contains the generated id.
     *
     * @param round Object containing the Round data.
     * @return Generated Round object.
     */
    @Override
    public Round create(final Round round) {
        List<Round> roundList;
        if (rounds.containsKey(round.getUserId())) {
            roundList = rounds.get(round.getUserId());
        } else {
            roundList = new ArrayList<Round>();
            rounds.put(round.getUserId(), roundList);
        }
        roundList.add(round);
        updateTotals(round);
        return round;
    }

    @Override
    public List<Round> findByUser(final UserCriteria criteria) {
        if (rounds.containsKey(criteria.getUserId())) {
            return rounds.get(criteria.getUserId());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public int count(final String userId) {
        if (rounds.containsKey(userId)) {
            return rounds.get(userId).size();
        } else {
            return 0;
        }
    }

    /**
     * This method restarts the rounds data stored for a single user, but not
     * the total data.
     *
     * @param userId User whose rounds will be cleared
     */
    @Override
    public void restart(String userId) {
        if (rounds.containsKey(userId)) {
            rounds.get(userId).clear();
        }
    }

    @Override
    public Totals getTotals() {
        return totals;
    }

    /**
     * We will assume that the round has been successfully created.
     *
     * @param round Round object.
     */
    private void updateTotals(Round round) {
        totals.addTotalRounds(1);

        switch (round.getResult()) {
            case PLAYER_1:
                totals.addPlayerOneWins(1);
                break;
            case PLAYER_2:
                totals.addPlayerTwoWins(1);
                break;
            case DRAW:
                totals.addDraws(1);
                break;
        }
    }

}
