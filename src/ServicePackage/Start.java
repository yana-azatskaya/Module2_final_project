package ServicePackage;
import AnimalCreator.AnimalContainer;
import AnimalCreator.AnimalFactory;
import Animals.Animal;
import World.World;
import World.WorldCreator;
import World.WorldRepopulationService;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.*;

public class Start {
    public static void start() throws IOException {
        World.setWorld(WorldCreator.createWorld());
        Map <String, Animal> animalData = MetaDataReader.readMetaData(AnimalContainer.class, "src/resources/animalsMetaData.yaml").getAnimals();
        AnimalFactory.setAnimalData(animalData);
        WorldRepopulationService.RepopulateWorld(animalData, World.getWorld());

        System.out.println("The start state of the world:\n" + Arrays.deepToString(World.getWorld()));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        executor.scheduleWithFixedDelay(new AnimalLifeProcessRunner(), 0, 10, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new GrassGrowingRunner(), 5, 10, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new ReporterService(), 30, 20, TimeUnit.SECONDS);

        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("The programm stopped running succesfully");}, 1, TimeUnit.MINUTES);

        ScheduledExecutorService finalReport = Executors.newSingleThreadScheduledExecutor();
        finalReport.schedule(new FinalReport(), 1, TimeUnit.MINUTES);
        finalReport.shutdown();


    }
}
