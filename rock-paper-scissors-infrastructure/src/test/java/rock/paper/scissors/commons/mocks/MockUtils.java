package rock.paper.scissors.commons.mocks;

import org.mockito.Mockito;
import rock.paper.scissors.control.RoundRepositoryImpl;

/**
 *
 * @author jizumer
 */
public class MockUtils {

    public static String USER_ID = "mock_user_id";
    public static String USER_ID_2 = "mock_user_id_2";

    public static RoundRepositoryImpl roundRepository() {
        RoundRepositoryImpl result = Mockito.mock(RoundRepositoryImpl.class);
        return result;
    }

}
