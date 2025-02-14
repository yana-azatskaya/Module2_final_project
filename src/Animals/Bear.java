package Animals;

public class Bear extends Animal {

    public Bear(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
