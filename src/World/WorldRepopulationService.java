package World;

import AnimalActivityController.AnimalAmountInCellController;
import AnimalActivityController.AnimalMaxAmountInCellController;
import AnimalCreator.AnimalFactory;
import Animals.Animal;
import Exceptions.WrongInputException;
import Exceptions.ZeroAnimalPopulation;
import Grass.Grass;
import ServicePackage.MetaDataReader;
import ServicePackage.Randomasier;
import java.util.List;
import java.util.Map;

public class WorldRepopulationService {

    public static void RepopulateWorld(Map<String, Animal> animalData, List<FloraFauna>[][] world) throws ZeroAnimalPopulation, WrongInputException {

        WorldPopulation worldPopulation = null;
        try {
            worldPopulation = MetaDataReader.readMetaData(WorldPopulation.class, "src/resources/worldPopulation.yaml");
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
                    default -> throw new WrongInputException ("Your input contains unexpected value: " + animalType);
                };
                if (maxPopulation > 0) {
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
                else throw new ZeroAnimalPopulation("Start amount of " + animalType + " can not be found or equal to zero. Please check the input data");
            }
            for (int i = 0; i < worldPopulation.getStartGrass(); i++) {
                int x = new Randomasier().getChance(world.length - 1);
                int y = new Randomasier().getChance(world[0].length - 1);
                world[x][y].add(new Grass());
            }

            World.setWorld(world);
        }
    }
