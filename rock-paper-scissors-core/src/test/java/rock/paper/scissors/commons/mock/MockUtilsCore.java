package rock.paper.scissors.commons.mock;

import org.mockito.Mockito;
import rock.paper.scissors.business.control.RoundRepository;

/**
 *
 * General class to keep reusable mocks and mock properties.
 */
public class MockUtilsCore {

    public static String USER_ID = "mock_user_id";
    public static String USER_ID_2 = "mock_user_id_2";

    public static RoundRepository roundRepository() {
        RoundRepository result = Mockito.mock(RoundRepository.class);
        return result;
    }

}
