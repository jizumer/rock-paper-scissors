package rock.paper.scissors.business.entity;

import java.util.Random;

public enum Move {

    ROCK(0), PAPER(1), SCISSORS(2);

    public static Move randomMove() {
        Random random = new Random();
        int r = random.nextInt(3);
        Move result = null;
        for (Move m : Move.values()) {
            if (m.n == r) {
                result = m;
                break;
            }
        }
        return result;
    }

    private int n;

    Move(int n) {
        this.n = n;
    }

}
