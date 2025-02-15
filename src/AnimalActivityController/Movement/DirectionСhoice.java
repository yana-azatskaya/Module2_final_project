package AnimalActivityController.Movement;

import Animals.Animal;
import ServicePackage.Randomasier;
import java.util.List;

/*
class return the value to identify the direction of animal's movement, where:
0 - up
1 - down
2 - left
3 - right
 */
public class DirectionСhoice {

    public static List<Integer> chooseDirection(Animal animal) {
        Randomasier randomasier = new Randomasier();
        int direction;
        int cellsToGo;
        direction = randomasier.getChance(4);
        cellsToGo = randomasier.getChance(animal.getMaxMove()) + 1;

        return List.of(direction, cellsToGo);
    }
}
