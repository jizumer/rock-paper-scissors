package rock.paper.scissors.business.control;

import org.junit.Before;
import org.junit.Test;
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
    public void testCreate() {
        

    }

}
