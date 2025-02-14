package AnimalActivityController.EatingController;
import AnimalActivityController.Starvation;
import Animals.Animal;
import Grass.Grass;
import ServicePackage.MetaDataReader;
import World.*;
import java.io.IOException;
import java.util.*;

import static AnimalActivityController.EatingController.EatingProcessController.eatingSuccessful;
import static AnimalActivityController.EatingController.EatingProcessController.fullnessReducer;

public class EatService {
    private static Map <String, Map<String, Integer>> receiveEatingChance;
    public static void getEatingChance() throws IOException {
        EatingChanceContainer chanceToEat = MetaDataReader.readMetaData(EatingChanceContainer.class, "src/resources/crossEatingChance.yaml");
        receiveEatingChance = chanceToEat.getEatingChance();
    }
    public static void eat () throws IOException {
        getEatingChance();
        List<FloraFauna>[][] currentWorld = World.getWorld();
        for (int i = 0; i < currentWorld.length; i++) {
            for (int p = 0; p < currentWorld[0].length; p++) {
                Set<FloraFauna> toRemove = new HashSet<FloraFauna>();
                for (FloraFauna context : currentWorld [i][p]) {
                    if (context instanceof Animal) {
                        Animal castedAnimal = (Animal) context;
                        String animalType = castedAnimal.getClass().getSimpleName().toLowerCase();
                        boolean hasEaten = false;

                        if (receiveEatingChance.containsKey(animalType)) {
                            Iterator<FloraFauna> victimIterator = currentWorld[i][p].iterator();
                            while (victimIterator.hasNext() && !hasEaten) {

                                FloraFauna victim = victimIterator.next();
                                String victimType = victim.getClass().getSimpleName().toLowerCase();
                                if (receiveEatingChance.get(animalType).containsKey(victimType) && !toRemove.contains(victim) && eatingSuccessful(receiveEatingChance.get(animalType).get(victimType))) {
                                    toRemove.add(victim);
                                    castedAnimal.setFullness(Math.min(castedAnimal.getKgToBeFull(), castedAnimal.getFullness() + ((Animal) victim).getWeight()));
                                    hasEaten = true;
                                }
                            }
                        }
                        else {
                            Iterator<FloraFauna> grassIterator = currentWorld[i][p].iterator();
                            while (grassIterator.hasNext() && !hasEaten) {
                                FloraFauna food = grassIterator.next();
                                if (food instanceof Grass && !toRemove.contains(food)) {
                                    toRemove.add(food);
                                    castedAnimal.setFullness(Math.min(castedAnimal.getKgToBeFull(), castedAnimal.getFullness())+castedAnimal.getFullness()*0.4);
                                    hasEaten = true;
                                }
                            }
                        }
                        if (!hasEaten) {
                                fullnessReducer(castedAnimal);
                                if (Starvation.starve(castedAnimal)) {
                                    toRemove.add(castedAnimal);
                                }
                            }
                        }
                    }
                currentWorld[i][p].removeAll(toRemove);
                World.modifyOneCell(i, p, currentWorld[i][p]);
                }
            }
        }
}
