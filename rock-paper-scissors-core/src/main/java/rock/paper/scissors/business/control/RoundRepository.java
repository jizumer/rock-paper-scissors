package rock.paper.scissors.business.control;

import java.util.List;
import rock.paper.scissors.business.entity.Round;
import rock.paper.scissors.common.control.RpsRepository;
import rock.paper.scissors.common.params.UserCriteria;


public interface RoundRepository extends RpsRepository<Round> {

    
    Round create(Round round);

    
    List<Round> findByUser(UserCriteria criteria);

}
