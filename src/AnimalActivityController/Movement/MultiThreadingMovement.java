package AnimalActivityController.Movement;

import AnimalActivityController.AnimalAmountInCellController;
import AnimalActivityController.AnimalMaxAmountInCellController;
import Animals.Animal;
import World.FloraFauna;
import World.World;
import World.WorldCreator;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadingMovement {

    static final List<FloraFauna>[][] world = World.getWorld();

    public static void move() throws IOException {
        LocalTime startTime = LocalTime.now();
        List<FloraFauna>[][] worldAfterMovement = WorldCreator.createWorld();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < world.length; i++) {
            for (int p = 0; p < world[0].length; p++) {
                int finalI = i;
                int finalP = p;

                executor.submit(() -> {
                    Iterator<FloraFauna> iterator = world[finalI][finalP].iterator();
                    int newX = finalI, newY = finalP;
                    while (iterator.hasNext()) {
                        FloraFauna floraFauna = iterator.next();
                        if (floraFauna instanceof Animal) {
                            List<Integer> listOfDirection = DirectionСhoice.chooseDirection((Animal) floraFauna);
                            int cellsToGo = MovementValidator.validateMovement(listOfDirection, finalI, finalP);
                            switch (listOfDirection.getFirst()) {
                                case 0 -> newY = finalP - cellsToGo;
                                case 1 -> newY = finalP + cellsToGo;
                                case 2 -> newX = finalI - cellsToGo;
                                case 3 -> newX = finalI + cellsToGo;
                            }
                            synchronized (worldAfterMovement[newX][newY]) {
                                if (AnimalMaxAmountInCellController.controlAnimalMaxAmountInCell((Animal) floraFauna, AnimalAmountInCellController.countAnimal(worldAfterMovement[newX][newY]))) {
                                    worldAfterMovement[newX][newY].add(floraFauna);
                                } else worldAfterMovement[finalI][finalP].add(floraFauna);
                            }
                        }
                    }
                });
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("Some threads haven't been finished");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        World.setWorld(worldAfterMovement);
        LocalTime endTime = LocalTime.now();
        Duration diff = Duration.between(startTime, endTime);
        System.out.println(diff.toSeconds() + " " + diff.toMillis());
    }
}