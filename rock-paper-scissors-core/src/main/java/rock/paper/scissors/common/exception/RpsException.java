package rock.paper.scissors.common.exception;

public class RpsException extends Exception {

    public RpsExceptionCause getRpsCause() {
        return rpsCause;
    }

    public void setRpsCause(RpsExceptionCause rpsCause) {
        this.rpsCause = rpsCause;
    }

    private RpsExceptionCause rpsCause;

    public RpsException(String message, RpsExceptionCause rpsCause) {
        super(message);
        this.rpsCause = rpsCause;
    }

}
