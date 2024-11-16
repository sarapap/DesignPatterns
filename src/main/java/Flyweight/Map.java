package Flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public abstract class Map {
    protected Tile[][] map;
    protected int rows;
    protected int columns;
    protected Random random;

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.map = new Tile[rows][columns];
        this.random = new Random();
        generateMap();
    }

    protected abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = createTile();
            }
        }
    }

    public void render(GraphicsContext gc, TileGraphicFactory factory) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Tile tile = map[row][col];
                Image image = factory.getTileGraphic(tile.getType());
                gc.drawImage(image, col * 50, row * 50, 50, 50);
            }
        }
    }
}