package rock.paper.scissors.business.entity;

import java.io.Serializable;
import java.util.Objects;

public class Round implements Serializable {

    private String userId;
    private Move player1Move;
    private Move player2Move;
    private Result result;
    
    public Round(){
        //Default constructor
    }

    public Round(final Move p1, final Move p2,
            final Result result, final String userId) {
        this.player1Move = p1;
        this.player2Move = p2;
        this.result = result;
        this.userId = userId;

    }

    /**
     * @return the player1Move
     */
    public Move getPlayer1Move() {
        return player1Move;
    }

    /**
     * @param player1Move the player1Move to set
     */
    public void setPlayer1Move(Move player1Move) {
        this.player1Move = player1Move;
    }

    /**
     * @return the player2Move
     */
    public Move getPlayer2Move() {
        return player2Move;
    }

    /**
     * @param player2Move the player2Move to set
     */
    public void setPlayer2Move(Move player2Move) {
        this.player2Move = player2Move;
    }

    /**
     * @return the result
     */
    public Result getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getUserId());
        hash = 67 * hash + Objects.hashCode(this.getPlayer1Move());
        hash = 67 * hash + Objects.hashCode(this.getPlayer2Move());
        hash = 67 * hash + Objects.hashCode(this.getResult());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (!Objects.equals(this.getUserId(), other.getUserId())) {
            return false;
        }
        if (this.getPlayer1Move() != other.getPlayer1Move()) {
            return false;
        }
        if (this.getPlayer2Move() != other.getPlayer2Move()) {
            return false;
        }
        if (this.getResult() != other.getResult()) {
            return false;
        }
        return true;
    }
}
