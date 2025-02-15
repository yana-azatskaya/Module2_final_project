package Animals;

import lombok.Getter;


public class Bear extends Animal {
    static boolean predator = true;
    public Bear(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }
    @Override
    public boolean isPredator() {
        return true;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
