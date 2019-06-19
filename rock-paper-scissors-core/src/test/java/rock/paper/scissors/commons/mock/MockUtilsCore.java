package rock.paper.scissors.commons.mock;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Move;
import rock.paper.scissors.business.entity.Result;
import rock.paper.scissors.business.entity.Round;

/**
 *
 * General class to keep reusable mocks and mock properties.
 */
public class MockUtilsCore {

    public static String USER_ID = "mock_user_id";
    public static String USER_ID_2 = "mock_user_id_2";

    public static RoundRepository roundRepository() {
        RoundRepository result = Mockito.mock(RoundRepository.class);
        when(result.create(Mockito.any())).thenAnswer(new Answer<Round>() {

            @Override
            public Round answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return (Round) args[0];
            }
        });
        

        return result;
    }

    public static Round round() {
        Round result = new Round(Move.ROCK,
                Move.SCISSORS,
                Result.PLAYER_1,
                USER_ID);
        return result;
    }

}
