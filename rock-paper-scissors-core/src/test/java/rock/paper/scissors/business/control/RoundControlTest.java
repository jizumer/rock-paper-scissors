package rock.paper.scissors.business.control;

import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rock.paper.scissors.business.entity.Result;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.exception.RpsException;
import rock.paper.scissors.common.params.UserCriteria;
import rock.paper.scissors.commons.mock.MockUtilsCore;

public class RoundControlTest {

    RoundRepository roundRepositoryMock;
    private RoundControl instance;

    public RoundControlTest() {
    }

    @Before
    public void setUp() {
        roundRepositoryMock
                = MockUtilsCore.roundRepository();
        instance = new RoundControl(roundRepositoryMock);
    }

    @Test
    public void testCreate() throws RpsException {

        Round round = instance.create(MockUtilsCore.USER_ID);
        assertTrue(round.getUserId().equals(MockUtilsCore.USER_ID));

        //Reminder: player 1 is random. player 2 is always rock
        switch (round.getPlayer1Move()) {
            case PAPER:
                assertTrue(round.getResult() == Result.PLAYER_1);
                break;
            case ROCK:
                assertTrue(round.getResult() == Result.DRAW);
                break;
            case SCISSORS:
                assertTrue(round.getResult() == Result.PLAYER_2);
        }

    }

    @Test
    public void testRestart() throws RpsException {
        instance.restart(MockUtilsCore.USER_ID);
        Mockito.verify(roundRepositoryMock, Mockito.atLeastOnce())
                .restart(MockUtilsCore.USER_ID);
    }

    @Test
    public void testFindByUser() throws RpsException {
        Round round = instance.create(MockUtilsCore.USER_ID);
        assertTrue(round.getUserId().equals(MockUtilsCore.USER_ID));
        List<Round> resultList = instance.findByUser(MockUtilsCore.USER_ID);
        Mockito.verify(roundRepositoryMock, Mockito.atLeastOnce())
                .findByUser(Mockito.any(UserCriteria.class));
    }

    @Test
    public void testRoundEquals() throws RpsException {
        Round r1 = instance.create(MockUtilsCore.USER_ID);
        Round r2 = new Round(r1.getPlayer1Move(),
                r1.getPlayer2Move(),
                r1.getResult(),
                r1.getUserId());
        Assert.assertTrue(r1.equals(r2));
        Assert.assertTrue(r1.hashCode() == r2.hashCode());

    }

    @Test
    public void testTotals() throws RpsException {
        instance.getTotals();
        Mockito.verify(roundRepositoryMock, Mockito.atLeastOnce())
                .getTotals();
    }

    @Test
    public void testTotalsEquals() throws RpsException {
        Totals t1 = instance.getTotals();
        Totals t2 = new Totals();

        Assert.assertTrue(t1.equals(t2));
        Assert.assertTrue(t1.hashCode() == t2.hashCode());

        t2.addDraws(1);
        t2.addPlayerOneWins(1);
        t2.addPlayerTwoWins(1);
        t2.addTotalRounds(3);

        Assert.assertNotEquals(t1, t2);
        Assert.assertTrue(t1.hashCode() != t2.hashCode());

    }
}
