package rock.paper.scissors.adapter.round;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rock.paper.scissors.boundary.round.RoundCreateBoundaryCDI;
import rock.paper.scissors.boundary.round.RoundGetBoundaryCDI;
import rock.paper.scissors.boundary.round.RoundRestartBoundaryCDI;
import rock.paper.scissors.boundary.round.RoundTotalsBoundaryCDI;
import rock.paper.scissors.business.boundary.round.RoundCreateBoundary;
import rock.paper.scissors.business.boundary.round.RoundGetBoundary;
import rock.paper.scissors.business.boundary.round.RoundRestartBoundary;
import rock.paper.scissors.business.boundary.round.RoundTotalsBoundary;
import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.business.entity.Totals;
import rock.paper.scissors.common.exception.RpsException;
import rock.paper.scissors.commons.mocks.MockUtils;
import rock.paper.scissors.control.RoundControlImpl;
import rock.paper.scissors.control.RoundRepositoryImpl;

/**
 *
 * @author jizumer
 */
public class RoundE2ETest {

    private RoundGetAdapter getAdapter;
    private RoundCreateAdapter createAdapter;
    private RoundRestartAdapter restartAdapter;
    private RoundTotalsAdapter totalsAdapter;
    private int ITEMS_NUMBER = 10;

    public RoundE2ETest() {
    }

    @Before
    public void setUp() {

        //Repo
        RoundRepository roundRepository = new RoundRepositoryImpl();
        //Control
        RoundControl control = new RoundControlImpl(roundRepository);
        //Boundaries
        RoundGetBoundary<List<Round>> getBoundary = new RoundGetBoundaryCDI(control);
        RoundCreateBoundary<Round> createBoundary = new RoundCreateBoundaryCDI(control);
        RoundRestartBoundary restartBoundary = new RoundRestartBoundaryCDI(control);
        RoundTotalsBoundary totalsBoundary = new RoundTotalsBoundaryCDI(control);

        //And finally, the adapters
        getAdapter = new RoundGetAdapter(getBoundary);
        createAdapter = new RoundCreateAdapter(createBoundary);
        restartAdapter = new RoundRestartAdapter(restartBoundary);
        totalsAdapter = new RoundTotalsAdapter(totalsBoundary);

    }

    @Test
    public void testE2E() throws RpsException {

        //initial situation
        List<Round> rounds = getAdapter.findByUser(MockUtils.USER_ID);
        Assert.assertTrue(rounds != null && rounds.isEmpty());
        Totals totals = totalsAdapter.getTotals();
        Assert.assertTrue(totals != null && totals.getTotalRounds() == 0);

        //lets insert some rounds for one player
        for (int i = 0; i < ITEMS_NUMBER; i++) {
            createAdapter.create(MockUtils.USER_ID);
        }
        rounds = getAdapter.findByUser(MockUtils.USER_ID);
        Assert.assertTrue(rounds != null && rounds.size() == ITEMS_NUMBER);
        totals = totalsAdapter.getTotals();
        Assert.assertTrue(totals != null
                && totals.getTotalRounds() == ITEMS_NUMBER);

        //Any other users data must be empty
        rounds = getAdapter.findByUser(MockUtils.USER_ID_2);
        Assert.assertTrue(rounds != null && rounds.isEmpty());

        //Now we will add one round to the second user
        createAdapter.create(MockUtils.USER_ID_2);

        //First users data must remain
        rounds = getAdapter.findByUser(MockUtils.USER_ID);
        Assert.assertTrue(rounds != null && rounds.size() == ITEMS_NUMBER);
        totals = totalsAdapter.getTotals();
        Assert.assertTrue(totals != null
                && totals.getTotalRounds() == ITEMS_NUMBER + 1);
        //and second user´s data must be stored
        rounds = getAdapter.findByUser(MockUtils.USER_ID_2);
        Assert.assertTrue(rounds != null && rounds.size() == 1);

        //If we restart one of the user´s data, totals, and the other 
        //user´s date must remain stored
        restartAdapter.restart(MockUtils.USER_ID);
        rounds = getAdapter.findByUser(MockUtils.USER_ID);
        Assert.assertTrue(rounds != null && rounds.isEmpty());
        totals = totalsAdapter.getTotals();
        Assert.assertTrue(totals != null
                && totals.getTotalRounds() == ITEMS_NUMBER + 1);
        rounds = getAdapter.findByUser(MockUtils.USER_ID_2);
        Assert.assertTrue(rounds != null && rounds.size() == 1);

    }

}
