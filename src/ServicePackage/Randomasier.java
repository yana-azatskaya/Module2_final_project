package ServicePackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomasier {
    public int chance;
    public int getChance(int maxChance) {
        chance = ThreadLocalRandom.current().nextInt(maxChance);
        return chance;
    }
}
