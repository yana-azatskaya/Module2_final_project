package AnimalActivityController.Movement;

import World.World;

import java.util.List;

public class MovementValidator {
    public static int validateMovement(List<Integer> directionList, int x, int y) {
        int newCellsToGo = 0;
        switch (directionList.get(0)) {
            case 0 -> newCellsToGo = Math.min(directionList.get(1), y);
            case 1 -> newCellsToGo = Math.min(directionList.get(1), World.getWorld()[0].length - y - 1);
            case 2 -> newCellsToGo = Math.min(directionList.get(1), x);
            case 3 -> newCellsToGo = Math.min(directionList.get(1), World.getWorld()[0].length - x - 1);
        }
        return newCellsToGo;
    }
}
