package ServicePackage;

import AnimalActivityController.AnimalAmountInCellController;
import World.FloraFauna;
import World.World;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class ReporterService implements Runnable {
    @Override
    public void run() {
        List<FloraFauna>[][] currentWorld = World.getWorld();
        Map<String, Integer> report = new HashMap<>();
        for (List<FloraFauna>[] lists : currentWorld) {
            IntStream.range(0, currentWorld[0].length).mapToObj(p -> AnimalAmountInCellController.countAnimal(lists[p])).filter(Objects::nonNull).forEach(cellReport -> {
                for (String reportedAnimal : cellReport.keySet()) {
                    if (report.containsKey(reportedAnimal)) {
                        report.replace(reportedAnimal, report.get(reportedAnimal) + cellReport.get(reportedAnimal));
                    } else report.put(reportedAnimal, cellReport.get(reportedAnimal));
                }
            });
        }
        System.out.println("At " + LocalTime.now() + " the state of the world is as follows: ");
        report.forEach((key, value) -> System.out.println("number of " + key + ": " + value));
        System.out.println("------------------");

    }
}
