package rock.paper.scissors.business.control;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rock.paper.scissors.business.entity.Result;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.exception.RpsException;
import rock.paper.scissors.commons.mock.MockUtilsCore;

public class RoundControlTest {

    private RoundControl instance;

    public RoundControlTest() {
    }

    @Before
    public void setUp() {
        RoundRepository roundRepositoryMock
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

}
