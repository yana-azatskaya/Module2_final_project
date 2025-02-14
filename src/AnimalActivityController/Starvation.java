package AnimalActivityController;
import Animals.Animal;

public class Starvation {
    public static boolean starve (Animal animal) {
        if (animal.getFullness() < animal.getKgToBeFull()*0.1) {
            return true;
        }
        else return false;
    }
}
