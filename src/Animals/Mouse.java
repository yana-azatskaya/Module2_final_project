package Animals;

public class Mouse extends Animal {
    public Mouse(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }

    public String toString() {
        return "\uD83D\uDC01";
    }
}
