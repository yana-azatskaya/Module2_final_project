package World;

import lombok.Setter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Setter
public class World {

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    public static List<FloraFauna>[][] world;
    int length;
    int width;


    public World() {
    }

    public World(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static List<FloraFauna>[][] getWorld() {
        lock.readLock().lock();
        try {
            return world;
        } finally {
            lock.readLock().unlock();
        }

    }

    public static void setWorld(List<FloraFauna>[][] worldToSet) {
        World.world = worldToSet;
    }

    public static void modifyOneCell(int x, int y, List<FloraFauna> floraFaunaList) {
        try {
            if (lock.writeLock().tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    world[x][y] = floraFaunaList;
                } finally {
                    lock.writeLock().unlock();

                }
            } else {
                System.out.printf("The change of cell ( %n;%n) wasn't successful", x, y);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

}
