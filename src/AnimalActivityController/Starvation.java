package AnimalActivityController;

import Animals.Animal;

public class Starvation {
    public static boolean starve(Animal animal) {
        return animal.getFullness() < animal.getKgToBeFull() * 0.1;
    }
}
