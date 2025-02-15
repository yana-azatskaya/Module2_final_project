package World;

import AnimalActivityController.AnimalAmountInCellController;
import AnimalActivityController.AnimalMaxAmountInCellController;
import AnimalCreator.AnimalFactory;
import Animals.Animal;
import Exceptions.WrongInputException;
import Grass.Grass;
import ServicePackage.MetaDataReader;
import ServicePackage.Randomasier;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WorldRepopulationService {

    public static void RepopulateWorld(Map<String, Animal> animalData, List<FloraFauna>[][] world) throws IOException {

        WorldPopulation worldPopulation = null;
        try {
            worldPopulation = MetaDataReader.readMetaData(WorldPopulation.class, "src/resources/worldPopulation.yaml");
            System.out.println(worldPopulation);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

            for (String animalType : animalData.keySet()) {
                int maxPopulation = switch (animalType) {
                    case "bear" -> worldPopulation.getStartBear();
                    case "deer" -> worldPopulation.getStartDeer();
                    case "fox" -> worldPopulation.getStartFox();
                    case "horse" -> worldPopulation.getStartHorse();
                    case "snake" -> worldPopulation.getStartSnake();
                    case "wolf" -> worldPopulation.getStartWolf();
                    case "mouse" -> worldPopulation.getStartMouse();
                    default -> throw new IllegalStateException("Unexpected value: " + animalType);
                };

                int amountOfAnimal = new Randomasier().getChance(maxPopulation);
                for (int i = 0; i < amountOfAnimal; i++) {
                    Animal animal = AnimalFactory.createAnimal(animalType);
                    int x = new Randomasier().getChance(world.length - 1);
                    int y = new Randomasier().getChance(world[0].length - 1);
                    if ((AnimalMaxAmountInCellController.controlAnimalMaxAmountInCell(animal, AnimalAmountInCellController.countAnimal(world[x][y])))) {
                        world[x][y].add(animal);
                    }
                }
            }
            for (int i = 0; i < worldPopulation.getStartGrass(); i++) {
                int x = new Randomasier().getChance(world.length - 1);
                int y = new Randomasier().getChance(world[0].length - 1);
                world[x][y].add(new Grass());
            }

            World.setWorld(world);
        }
    }
