package Animals;

import lombok.Getter;

@Getter
public class Fox extends Animal {
    public Fox(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        super(weight, maxInCell, maxMove, kgToBeFull, chanceToReproduce);
    }

    @Override
    public boolean isPredator() {
        return true;
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}
