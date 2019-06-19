package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.common.params.UserCriteria;


public interface RoundGetBoundary<O> {

    
    O findByUser(UserCriteria criteria);

}
