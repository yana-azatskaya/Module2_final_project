package AnimalActivityController;

import AnimalCreator.AnimalFactory;
import Animals.Animal;
import Exceptions.WrongInputException;
import ServicePackage.Randomasier;
import World.FloraFauna;
import World.World;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReproduceService {
    public static void reproduce() throws WrongInputException {
        List<FloraFauna>[][] worldAfterReproducing = World.getWorld();

        for (int i = 0; i < worldAfterReproducing.length; i++) {
            for (int p = 0; p < worldAfterReproducing[0].length; p++) {
                if (!worldAfterReproducing[i][p].isEmpty()) {
                    World.modifyOneCell(i, p, reproduceAnimal(worldAfterReproducing[i][p]));
                }
            }
        }
    }

    public static Map<String, Integer> controlReproducing(Map<String, Integer> animalCount) {
        if (animalCount != null) {
            return animalCount.entrySet().stream()
                    .filter(entry -> entry.getValue() >= 2)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        return null;

    }

    public static List<FloraFauna> reproduceAnimal(List<FloraFauna> allWorld)  throws WrongInputException {

        Map<String, Integer> animalPairs = controlReproducing(AnimalAmountInCellController.countAnimal(allWorld));
        if (animalPairs != null) {
            Map<String, Integer> animalCanBeBorn = animalPopulationAfterReproducingController(allWorld);
            for (String key : animalPairs.keySet()) {
                if (successfulReproduce(AnimalFactory.createAnimal(key))) {
                    int animalToBorn = Math.min(animalCanBeBorn.get(key), new Randomasier().getChance(Animal.getPossibleNumberOfBabies()) + 1);
                    if (animalToBorn != 0) {
                        for (int i = 0; i < animalToBorn; i++) {
                            Animal animalBaby = AnimalFactory.createAnimal(key);
                            allWorld.add(animalBaby);
                        }
                    }
                }
            }
        }
        return allWorld;
    }

    public static Map<String, Integer> animalPopulationAfterReproducingController(List<FloraFauna> animal) {
        Map<String, Integer> animalCanBeBorn = AnimalAmountInCellController.countAnimal(animal);
        animalCanBeBorn.replaceAll((key, value) -> {
            try {
                return AnimalFactory.createAnimal(key).getMaxInCell() - value;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return animalCanBeBorn;
    }

    public static boolean successfulReproduce(Animal animal) {
        int chance = new Randomasier().getChance(100);
        return chance < animal.getChanceToReproduce();
    }
}
