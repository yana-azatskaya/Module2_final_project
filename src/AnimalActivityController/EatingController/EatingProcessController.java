package AnimalActivityController.EatingController;

import Animals.Animal;
import ServicePackage.Randomasier;

public class EatingProcessController {
    public static boolean eatingSuccessful(int chance) {
        int generatedChance = new Randomasier().getChance(100);
        return generatedChance <= chance;
    }

    public static void fullnessReducer(Animal animal) {

        animal.setFullness(animal.getFullness() - animal.getFullness() * 0.5);

    }
}
