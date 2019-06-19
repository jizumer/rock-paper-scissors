package rock.paper.scissors.business.boundary.round;

public interface RoundCreateBoundary<R> {

    R create(String userId);

}
