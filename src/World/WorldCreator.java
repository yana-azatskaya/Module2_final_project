package World;

import Exceptions.WrongInputException;
import ServicePackage.MetaDataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* класс используется для создания пустого мира, возвращает массив листов Анималов: при первичном создании мира, при создании его копии для перемещения животных */
public class WorldCreator {
    public static List<FloraFauna>[][] createWorld() throws WrongInputException {
        World createdWorld = MetaDataReader.readMetaData(WorldWrapper.class, "src/resources/worldCharacteristic.yaml").getWorld();
        List<FloraFauna>[][] world = new ArrayList[createdWorld.getLength()][createdWorld.getWidth()];
        for (int i = 0; i < world.length; i++) {
            for (int p = 0; p < world[0].length; p++) {
                world[i][p] = new ArrayList<>();
            }
        }
        return world;
    }
}


