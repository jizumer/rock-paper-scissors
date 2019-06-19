package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.common.params.UserCriteria;

public interface RoundRestartBoundary {

    void restart(UserCriteria criteria);

}
