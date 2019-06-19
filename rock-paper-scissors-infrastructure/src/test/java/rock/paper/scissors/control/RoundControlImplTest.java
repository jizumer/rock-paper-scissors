package rock.paper.scissors.control;

import rock.paper.scissors.commons.mocks.MockUtils;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.exception.RpsException;

/**
 *
 * @author jizumer
 */
public class RoundControlImplTest {

    private RoundControlImpl instance;

    public RoundControlImplTest() {

    }

    @Before
    public void setUp() {
        RoundRepositoryImpl repo = new RoundRepositoryImpl();
        instance = new RoundControlImpl(repo);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() throws RpsException {
        List<Round> rounds = instance.findByUser(MockUtils.USER_ID);
        assertTrue(rounds != null && rounds.isEmpty());
        assertTrue(instance.getTotals().getTotalRounds() == 0);

        instance.create(MockUtils.USER_ID);
        List<Round> rounds2 = instance.findByUser(MockUtils.USER_ID);
        assertTrue(rounds2 != null && rounds2.size() == 1);

        Round newRound = rounds2.get(0);
        Totals newTotals = instance.getTotals();

        assertTrue(newTotals.getTotalRounds() == 1);

        //Lets verify the result of the random move generator
        switch (newRound.getResult()) {
            case DRAW:
                assertTrue(newTotals.getDraws() == 1);
                assertTrue(newTotals.getPlayerOneWins() == 0);
                assertTrue(newTotals.getPlayerTwoWins() == 0);
                break;
            case PLAYER_1:
                assertTrue(newTotals.getDraws() == 0);
                assertTrue(newTotals.getPlayerOneWins() == 1);
                assertTrue(newTotals.getPlayerTwoWins() == 0);
                break;
            case PLAYER_2:
                assertTrue(newTotals.getDraws() == 0);
                assertTrue(newTotals.getPlayerOneWins() == 0);
                assertTrue(newTotals.getPlayerTwoWins() == 1);

        }
    }

}
