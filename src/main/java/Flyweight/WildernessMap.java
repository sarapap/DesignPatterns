package Flyweight;

import java.util.Random;

public class WildernessMap extends Map {
    private static final Tile[] WILDERNESSMAP = {
            new TileClass("S", "swamp"),
            new TileClass("W", "water"),
            new TileClass("F", "forest")
    };

    public WildernessMap(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    protected Tile createTile() {
        return WILDERNESSMAP[new Random().nextInt(WILDERNESSMAP.length)];
    }
}