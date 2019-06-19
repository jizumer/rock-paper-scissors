package rock.paper.scissors.boundary.round;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import rock.paper.scissors.business.boundary.round.RoundGetBoundary;
import rock.paper.scissors.business.boundary.round.RoundGetBoundaryImpl;
import rock.paper.scissors.business.control.RoundRepository;
import rock.paper.scissors.business.entity.Round;

@Singleton
@Named("round-get-infrastructure")
public class RoundGetBoundaryCDI extends RoundGetBoundaryImpl
        implements RoundGetBoundary<List<Round>> {

    @Inject
    public RoundGetBoundaryCDI(final RoundRepository repository) {
        super(repository);
    }

}
