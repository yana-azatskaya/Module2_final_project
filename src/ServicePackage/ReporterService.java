package ServicePackage;
import AnimalActivityController.AnimalAmountInCellController;
import World.FloraFauna;
import World.World;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporterService  implements Runnable{
    @Override
    public void run() {
        List<FloraFauna>[][] currentWorld = World.getWorld();
        Map<String, Integer> report = new HashMap<>();
        for (int i = 0; i < currentWorld.length; i++){
            for (int p = 0; p < currentWorld[0].length; p++) {
                Map<String, Integer> cellReport = AnimalAmountInCellController.countAnimal(currentWorld[i][p]);
                if (cellReport != null) {
                    for (String reportedAnimal : cellReport.keySet()) {
                        if (report.containsKey(reportedAnimal)) {
                            report.replace(reportedAnimal, report.get(reportedAnimal) + cellReport.get(reportedAnimal));
                        } else report.put(reportedAnimal, cellReport.get(reportedAnimal));
                    }
                }
            }
        }
        System.out.println("At " + LocalTime.now() + " the state of the world is as follows: ");
        report.forEach((key, value) -> System.out.println("number of " + key  + ": " + value));
        System.out.println("------------------");

    }
}
