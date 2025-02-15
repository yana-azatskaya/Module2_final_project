package AnimalActivityController;

import Animals.Animal;
import World.FloraFauna;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalAmountInCellController {
    public static Map<String, Integer> countAnimal(List<FloraFauna> floraFaunaList) {
        Map<String, Integer> animalCount = null;
        List<Animal> animalList = floraFaunaList.stream()
                .filter((floraFauna) -> floraFauna instanceof Animal)
                .map((floraFauna) -> (Animal) floraFauna)
                .toList();

        if (!animalList.isEmpty()) {
            animalCount = animalList.stream()
                    .collect(Collectors.toMap(
                            animal -> animal.getClass().getSimpleName().toLowerCase(),
                            animal -> 1,
                            Integer::sum
                    ));
        }
        return animalCount;
    }
}
