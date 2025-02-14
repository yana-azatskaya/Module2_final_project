package ServicePackage;
import Grass.Grass;
public class GrassGrowingRunner implements Runnable {
    @Override
    public void run() {
        Grass.grassGrowing();
        System.out.println("Grass has grown");
    }
}
