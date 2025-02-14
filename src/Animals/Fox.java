package Animals;

public class Fox extends Animal {
    public Fox(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}
