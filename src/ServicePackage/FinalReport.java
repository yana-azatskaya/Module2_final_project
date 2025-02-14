package ServicePackage;

import World.World;

import java.util.Arrays;

public class FinalReport implements Runnable {
    public void run() {
        System.out.println("The final state of the world:\n" + Arrays.deepToString(World.getWorld()));
    }
}
