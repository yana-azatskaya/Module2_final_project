package AnimalActivityController;
import Animals.Animal;
import java.util.Map;

public class AnimalMaxAmountInCellController {
    public static boolean controlAnimalMaxAmountInCell (Animal CheckedAnimal, Map<String, Integer> animalCount) {

            if (animalCount != null) {
                if(animalCount.containsKey(CheckedAnimal.getClass().getSimpleName())) {
                    if (animalCount.get(CheckedAnimal.getClass().getSimpleName()) + 1 <= CheckedAnimal.getMaxInCell())
                        return true;
                    else return false;
                }
                else return true;
            }
            else return true;
        }
    }
