package rock.paper.scissors.business.entity;

import java.io.Serializable;

public class Round implements Serializable {

    private String userId;
    private Move player1Move;
    private Move player2Move;
    private Result result;

    public Round(Move p1, Move p2, Result result) {
        this.player1Move = p1;
        this.player2Move = p2;
        this.result = result;

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

}
