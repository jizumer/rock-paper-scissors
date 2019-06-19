package rock.paper.scissors.control;

import javax.inject.Inject;
import javax.inject.Singleton;
import rock.paper.scissors.business.control.RoundControl;
import rock.paper.scissors.business.control.RoundRepository;

@Singleton
public class RoundControlImpl extends RoundControl {

    @Inject
    public RoundControlImpl(
            final RoundRepository roundRepository) {
        super(roundRepository);
    }

}
