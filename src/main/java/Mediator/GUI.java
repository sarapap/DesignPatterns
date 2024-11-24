package Mediator;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI {
    private final ChatUser client;
    private final TextField inputArea;
    private final ComboBox<String> receiverArea;
    private final ListView<String> messageArea;

    public GUI(ChatUser client) {
        this.client = client;
        messageArea = new ListView<>();
        inputArea = new TextField();
        receiverArea = new ComboBox<>();
    }

    public void display() {
        Stage stage = new Stage();

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String message = inputArea.getText();
            String receiver = receiverArea.getValue();
            client.send(message, receiver);
            displayMessage("Me: " + message + " (to " + receiver + ")");
            inputArea.clear();
        });

        VBox layout = new VBox(new Label("Receiver: "), receiverArea, new Label("Message: "), inputArea, sendButton, messageArea);
        layout.setSpacing(10);
        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle(client.getName());
        stage.show();
    }

    public void updateReceivers(String[] users) {
        receiverArea.getItems().setAll(users);
    }

    public void displayMessage(String message) {
        messageArea.getItems().add(message);
    }
}
