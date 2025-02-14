package Grass;

import ServicePackage.Randomasier;
import World.FloraFauna;
import World.World;

import java.util.List;

public class Grass extends FloraFauna {
    Grass grass;

    public static void grassGrowing() {
        List<FloraFauna>[][] worldWithGrass = World.getWorld();
        for (int i = 0; i < worldWithGrass.length * worldWithGrass[0].length * 0.3; i++) {
            int x = new Randomasier().getChance(worldWithGrass.length);
            int y = new Randomasier().getChance(worldWithGrass[0].length);

            worldWithGrass[x][y].add(new Grass());
            World.modifyOneCell(x, y, worldWithGrass[x][y]);

        }
    }

    @Override
    public String toString() {
        return "\uD83C\uDF31";
    }
}
