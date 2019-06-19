package rock.paper.scissors.business.control;

import java.util.List;
import java.util.Random;
import rock.paper.scissors.business.entity.Move;
import rock.paper.scissors.business.entity.Result;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.exception.RpsException;
import rock.paper.scissors.common.exception.RpsExceptionCause;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundControl {

    private RoundRepository roundRepository;
    private Random random;

    public RoundControl(final RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
        this.random = new Random();

    }

    public Round create(final String userId) throws RpsException {
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
     * In the problem statement says:
     *
     * "There will be 2 kinds of players, one should always choose randomly, the
     * other should always choose rock."
     *
     * We will assume that the player 1 will be always a random player, and the
     * second one will always be the "rock player".
     *
     * @param userId Application user id. The round record will store this id.
     * @return The generated Round object.
     */
    private Round play(String userId) throws RpsException {

        Move randomMove = Move.randomMove();
        Result result = null;

        //calculate the result, assuming that the other move is always rock
        //Lets verify the result of the random move generator
        switch (randomMove) {
            case PAPER:
                //player 1 wins
                result = Result.PLAYER_1;
                break;
            case ROCK:
                //draw
                result = Result.DRAW;
                break;
            case SCISSORS:
                //player 2 wins
                result = Result.PLAYER_2;
                break;
            default:
                throw new RpsException("Unexpected round result.",
                        RpsExceptionCause.INTERNAL_ERROR);
        }

        return new Round(randomMove, Move.ROCK, result, userId);

    }

}
