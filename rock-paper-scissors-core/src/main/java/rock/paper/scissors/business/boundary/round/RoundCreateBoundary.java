package rock.paper.scissors.business.boundary.round;

import rock.paper.scissors.common.exception.RpsException;

public interface RoundCreateBoundary<R> {

    R create(String userId) throws RpsException;

}
