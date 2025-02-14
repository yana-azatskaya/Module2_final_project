package World;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldWrapper {
    @JsonProperty("world")
    private World world;

    public World getWorld() {
        return world;
    }

}
