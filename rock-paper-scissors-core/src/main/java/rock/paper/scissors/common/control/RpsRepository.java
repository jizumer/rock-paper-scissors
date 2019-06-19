package rock.paper.scissors.common.control;

import java.io.Serializable;


public interface RpsRepository<O> extends Serializable {


    O findAll();

}
