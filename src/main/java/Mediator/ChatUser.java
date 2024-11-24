package Mediator;

import javafx.application.Platform;

public class ChatUser {
    private final String name;
    private final ChatMediator mediator;
    private final GUI gui;

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.gui = new GUI(this);
        mediator.register(this);
    }

    public String getName() {
        return name;
    }

    public void send(String message, String receiver) {
        mediator.sendMessage(message, name, receiver);
    }

    public void receive(String message, String sender) {
        Platform.runLater(() -> gui.displayMessage(sender + ": " + message));
    }

    public void updateReceivers(String[] users) {
        Platform.runLater(() -> gui.updateReceivers(users));
    }

    public void display() {
        gui.display();
    }
}

