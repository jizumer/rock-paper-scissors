package rock.paper.scissors.business.entity;

import java.util.Objects;

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

    public void addTotalRounds(int i) {
        this.totalRounds += 1;
    }

    public void addPlayerOneWins(int i) {
        this.playerOneWins += 1;
    }

    public void addPlayerTwoWins(int i) {
        this.playerTwoWins += 1;
    }

    public void addDraws(int i) {
        this.draws += 1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.totalRounds);
        hash = 17 * hash + Objects.hashCode(this.playerOneWins);
        hash = 17 * hash + Objects.hashCode(this.playerTwoWins);
        hash = 17 * hash + Objects.hashCode(this.draws);
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
        final Totals other = (Totals) obj;
        if (!Objects.equals(this.totalRounds, other.totalRounds)) {
            return false;
        }
        if (!Objects.equals(this.playerOneWins, other.playerOneWins)) {
            return false;
        }
        if (!Objects.equals(this.playerTwoWins, other.playerTwoWins)) {
            return false;
        }
        if (!Objects.equals(this.draws, other.draws)) {
            return false;
        }
        return true;
    }

}
