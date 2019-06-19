package rock.paper.scissors.control;

import rock.paper.scissors.commons.mocks.MockUtils;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rock.paper.scissors.business.entity.Move;
import rock.paper.scissors.business.entity.Result;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.params.UserCriteria;

public class RoundRepositoryImplTest {

    private RoundRepositoryImpl instance;

    public RoundRepositoryImplTest() {
        //Default constructor
    }

    @Before
    public void setUp() {
        //This set up is very simple, since target class does not need
        //external collaborators.
        instance = new RoundRepositoryImpl();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class RoundRepositoryImpl.
     */
    @Test
    public void test() {
        assertEquals(instance.count(MockUtils.USER_ID), 0);
        List<Round> emptyList = 
                instance.findByUser(new UserCriteria(MockUtils.USER_ID));
        assertTrue(emptyList != null && emptyList.isEmpty());
        Round round
                = new Round(Move.ROCK, 
                        Move.PAPER, 
                        Result.PLAYER_2, 
                        MockUtils.USER_ID);
        Round returnedRound = instance.create(round);

        assertEquals(returnedRound, round);
        assertEquals(instance.count(MockUtils.USER_ID), 1);
        List<Round> notEmptyList
                = instance.findByUser(new UserCriteria(MockUtils.USER_ID));
        assertTrue(notEmptyList != null && notEmptyList.size() == 1);

    }

    /**
     * Test of findByUser method, of class RoundRepositoryImpl.
     */
    @Test
    public void testFindByUser() {
        assertEquals(instance.count(MockUtils.USER_ID), 0);

        //Inserting one round
        Round round
                = new Round(Move.SCISSORS,
                        Move.PAPER,
                        Result.PLAYER_1,
                        MockUtils.USER_ID);
        instance.create(round);

        List<Round> resultList1
                = instance.findByUser(new UserCriteria(MockUtils.USER_ID));
        assertTrue(resultList1 != null && resultList1.size() == 1);
        assertEquals(resultList1.get(0), round);

        //Lets insert one more round
        Round round2
                = new Round(Move.SCISSORS,
                        Move.ROCK,
                        Result.PLAYER_2,
                        MockUtils.USER_ID);
        instance.create(round2);

        List<Round> resultList2
                = instance.findByUser(new UserCriteria(MockUtils.USER_ID));
        assertTrue(resultList2 != null && resultList2.size() == 2);
        assertEquals(resultList1.get(1), round2);

    }

    /**
     * Test of restart method, of class RoundRepositoryImpl.
     */
    @Test
    public void testRestart() {
        assertEquals(instance.count(MockUtils.USER_ID), 0);
        assertEquals(instance.getTotals().getTotalRounds(), new Integer(0));

        //Inserting one round
        Round round
                = new Round(Move.SCISSORS,
                        Move.PAPER,
                        Result.PLAYER_1,
                        MockUtils.USER_ID);
        instance.create(round);

        assertEquals(instance.count(MockUtils.USER_ID), 1);
        assertEquals(instance.getTotals().getTotalRounds(), new Integer(1));
        assertEquals(instance.getTotals().getDraws(), new Integer(0));
        assertEquals(instance.getTotals().getPlayerOneWins(), new Integer(1));
        assertEquals(instance.getTotals().getPlayerTwoWins(), new Integer(0));

        //This restart should not affect total indicators
        instance.restart(MockUtils.USER_ID);
        assertEquals(instance.count(MockUtils.USER_ID), 0);
        assertEquals(instance.getTotals().getTotalRounds(), new Integer(1));
        assertEquals(instance.getTotals().getDraws(), new Integer(0));
        assertEquals(instance.getTotals().getPlayerOneWins(), new Integer(1));
        assertEquals(instance.getTotals().getPlayerTwoWins(), new Integer(0));
    }

    /**
     * Test of getTotals method, of class RoundRepositoryImpl.
     */
    @Test
    public void testGetTotals() {
        assertEquals(instance.count(MockUtils.USER_ID), 0);
        assertEquals(instance.getTotals().getTotalRounds(), new Integer(0));

        //Inserting one round
        Round round
                = new Round(Move.SCISSORS,
                        Move.PAPER,
                        Result.PLAYER_1,
                        MockUtils.USER_ID);
        instance.create(round);

        //Lets insert one more round for a different user
        Round round2
                = new Round(Move.SCISSORS,
                        Move.ROCK,
                        Result.PLAYER_2,
                        MockUtils.USER_ID_2);
        instance.create(round2);

                //Lets insert a draw
        Round round3
                = new Round(Move.SCISSORS,
                        Move.SCISSORS,
                        Result.DRAW,
                        MockUtils.USER_ID_2);
        instance.create(round3);
        
        //Now we compare results
        List<Round> resultListUser1
                = instance.findByUser(new UserCriteria(MockUtils.USER_ID));
        assertTrue(resultListUser1 != null && resultListUser1.size() == 1);

        List<Round> resultListUser2
                = instance.findByUser(new UserCriteria(MockUtils.USER_ID_2));
        assertTrue(resultListUser2 != null && resultListUser2.size() == 2);

        assertEquals(instance.getTotals().getTotalRounds(), new Integer(3));
        assertEquals(instance.getTotals().getDraws(), new Integer(1));
        assertEquals(instance.getTotals().getPlayerOneWins(), new Integer(1));
        assertEquals(instance.getTotals().getPlayerTwoWins(), new Integer(1));
    }

}
