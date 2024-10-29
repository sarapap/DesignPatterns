package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label);
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
            showHistoryWindow();
        });

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    private void showHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("State History");

        ListView<String> listView = new ListView<>();

        for (String state : controller.getHistoryTime()) {
            listView.getItems().add(state);
        }

        listView.setOnMouseClicked(event -> {
            String selectedState = listView.getSelectionModel().getSelectedItem();
            if (selectedState != null) {
                controller.restoreStateFromTime(selectedState);
                updateGui();

                int index = controller.getHistoryTime().indexOf(selectedState);
                if (index != -1) {
                    controller.removeState(index);
                }
                listView.getItems().remove(selectedState);
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }

}
