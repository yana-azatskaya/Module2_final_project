package Animals;

import World.FloraFauna;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Animal extends FloraFauna {
    static int possibleNumberOfBabies = 5;
    double weight; //Animal's weight
    int maxInCell; //Maximum number of animals of this species per cell
    int maxMove; //Speed of movement, not more than, cells per turn
    double kgToBeFull; //How many kilograms of food an animal needs to be fully satiated
    int chanceToReproduce;
    double fullness;

    public Animal() {

    }

    public Animal(double weight, int maxInCell, int maxMove, double kgToBeFull, int chanceToReproduce) {
        this.weight = weight;
        this.maxInCell = maxInCell;
        this.maxMove = maxMove;
        this.kgToBeFull = kgToBeFull;
        this.chanceToReproduce = chanceToReproduce;
        this.fullness = kgToBeFull;
    }

    public static int getPossibleNumberOfBabies() {
        return possibleNumberOfBabies;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxInCell() {
        return maxInCell;
    }

    public int getMaxMove() {
        return maxMove;
    }

    public double getKgToBeFull() {
        return kgToBeFull;
    }

    public int getChanceToReproduce() {
        return chanceToReproduce;
    }

    public double getFullness() {
        return fullness;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }
}
