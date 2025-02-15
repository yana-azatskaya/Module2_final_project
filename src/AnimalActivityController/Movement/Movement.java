package AnimalActivityController.Movement;

import AnimalActivityController.AnimalAmountInCellController;
import AnimalActivityController.AnimalMaxAmountInCellController;
import Animals.Animal;
import Exceptions.WrongInputException;
import World.FloraFauna;
import World.World;
import World.WorldCreator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Movement {
    public static void move() throws WrongInputException {
        List<FloraFauna>[][] world = World.getWorld();
        List<FloraFauna>[][] worldAfterMovement = WorldCreator.createWorld();
        for (int i = 0; i < world.length; i++) {
            for (int p = 0; p < world[0].length; p++) {
                Iterator<FloraFauna> iterator = world[i][p].iterator();
                int newX = i, newY = p;
                while (iterator.hasNext()) {
                    FloraFauna floraFauna = iterator.next();
                    if (floraFauna instanceof Animal) {
                        List<Integer> listOfDirection = DirectionСhoice.chooseDirection((Animal) floraFauna);
                        int cellsToGo = MovementValidator.validateMovement(listOfDirection, i, p);
                        switch (listOfDirection.getFirst()) {
                            case 0 -> newY = p - cellsToGo;
                            case 1 -> newY = p + cellsToGo;
                            case 2 -> newX = i - cellsToGo;
                            case 3 -> newX = i + cellsToGo;
                        }
                        if (AnimalMaxAmountInCellController.controlAnimalMaxAmountInCell((Animal) floraFauna, AnimalAmountInCellController.countAnimal(worldAfterMovement[newX][newY]))) {
                            worldAfterMovement[newX][newY].add(floraFauna);
                        } else worldAfterMovement[i][p].add(floraFauna);
                    } else worldAfterMovement[i][p].add(floraFauna);
                }
                World.modifyOneCell(i, p, worldAfterMovement[i][p]);
            }
        }
    }
}
