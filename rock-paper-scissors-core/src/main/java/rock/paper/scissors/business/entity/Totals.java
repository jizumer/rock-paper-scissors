package rock.paper.scissors.business.entity;

public class Totals {

    private Integer totalRounds;
    private Integer playerOneWins;
    private Integer playerTwoWins;
    private Integer draws;

    public Totals() {
        totalRounds = 0;
        playerOneWins = 0;
        playerTwoWins = 0;
        draws = 0;
    }

    /**
     * @return the totalRounds
     */
    public Integer getTotalRounds() {
        return totalRounds;
    }

    /**
     * @param totalRounds the totalRounds to set
     */
    public void setTotalRounds(Integer totalRounds) {
        this.totalRounds = totalRounds;
    }

    /**
     * @return the playerOneWins
     */
    public Integer getPlayerOneWins() {
        return playerOneWins;
    }

    /**
     * @param playerOneWins the playerOneWins to set
     */
    public void setPlayerOneWins(Integer playerOneWins) {
        this.playerOneWins = playerOneWins;
    }

    /**
     * @return the playerTwoWins
     */
    public Integer getPlayerTwoWins() {
        return playerTwoWins;
    }

    /**
     * @param playerTwoWins the playerTwoWins to set
     */
    public void setPlayerTwoWins(Integer playerTwoWins) {
        this.playerTwoWins = playerTwoWins;
    }

    /**
     * @return the draws
     */
    public Integer getDraws() {
        return draws;
    }

    /**
     * @param draws the draws to set
     */
    public void setDraws(Integer draws) {
        this.draws = draws;
    }

}
