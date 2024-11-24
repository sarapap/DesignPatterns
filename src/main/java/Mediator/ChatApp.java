package Mediator;

import javafx.application.Application;

public class ChatApp extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) {
        ChatMediator mediator = new ChatMediator();
        ChatUser user1 = new ChatUser("Käyttäjä", mediator);
        ChatUser user2 = new ChatUser("Joku", mediator);
        ChatUser user3 = new ChatUser("Random", mediator);
        user1.display();
        user2.display();
        user3.display();
    }
}
