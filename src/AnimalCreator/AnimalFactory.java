package AnimalCreator;

import Animals.*;
import java.io.IOException;
import java.util.Map;

public class AnimalFactory {
    private static Map<String, Animal> animalData;

    public static void setAnimalData(Map<String, Animal> animalData) {
        AnimalFactory.animalData = animalData;
    }

    public static Animal createAnimal(String animalType) throws IOException {

        switch (animalType) {
            case "wolf" -> {
                return new Wolf(animalData.get("wolf").getWeight(), animalData.get("wolf").getMaxInCell(), animalData.get("wolf").getMaxMove(), animalData.get("wolf").getKgToBeFull(), animalData.get("wolf").getChanceToReproduce());
            }
            case "snake" -> {
                return new Snake(animalData.get("snake").getWeight(), animalData.get("snake").getMaxInCell(), animalData.get("snake").getMaxMove(), animalData.get("snake").getKgToBeFull(), animalData.get("snake").getChanceToReproduce());
            }
            case "fox" -> {
                return new Fox(animalData.get("fox").getWeight(), animalData.get("fox").getMaxInCell(), animalData.get("fox").getMaxMove(), animalData.get("fox").getKgToBeFull(), animalData.get("fox").getChanceToReproduce());
            }
            case "bear" -> {
                return new Bear(animalData.get("bear").getWeight(), animalData.get("bear").getMaxInCell(), animalData.get("bear").getMaxMove(), animalData.get("bear").getKgToBeFull(), animalData.get("bear").getChanceToReproduce());
            }
            case "horse" -> {
                return new Horse(animalData.get("horse").getWeight(), animalData.get("horse").getMaxInCell(), animalData.get("horse").getMaxMove(), animalData.get("horse").getKgToBeFull(), animalData.get("horse").getChanceToReproduce());
            }
            case "deer" -> {
                return new Deer(animalData.get("deer").getWeight(), animalData.get("deer").getMaxInCell(), animalData.get("deer").getMaxMove(), animalData.get("deer").getKgToBeFull(), animalData.get("deer").getChanceToReproduce());
            }
            case "mouse" -> {
                return new Mouse(animalData.get("mouse").getWeight(), animalData.get("mouse").getMaxInCell(), animalData.get("mouse").getMaxMove(), animalData.get("mouse").getKgToBeFull(), animalData.get("mouse").getChanceToReproduce());
            }
            default -> throw new IOException();
        }

    }
}
