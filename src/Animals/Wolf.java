package Animals;
public class Wolf extends Animal {
    public Wolf(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
