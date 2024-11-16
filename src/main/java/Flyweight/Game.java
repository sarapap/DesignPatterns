package Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private static final int TILE_SIZE = 50;

    @Override
    public void start(Stage stage) {
        TileGraphicFactory factory = new TileGraphicFactory();
        Map cityMap = createMap("city", ROWS, COLUMNS);
        Map wildernessMap = createMap("wilderness", ROWS, COLUMNS);

        Canvas canvas = new Canvas(COLUMNS * TILE_SIZE, ROWS * TILE_SIZE * 2);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.translate(0, 0);
        cityMap.render(gc, factory);

        gc.translate(0, 20);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(0, ROWS * TILE_SIZE, COLUMNS * TILE_SIZE, ROWS * TILE_SIZE);

        gc.translate(0, 20);

        gc.translate(0, ROWS * TILE_SIZE);
        wildernessMap.render(gc, factory);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Map createMap(String type, int rows, int cols) {
        if (type.equals("city")) {
            return new CityMap(rows, cols);
        } else if (type.equals("wilderness")) {
            return new WildernessMap(rows, cols);
        } else {
            return null;
        }
    }
}