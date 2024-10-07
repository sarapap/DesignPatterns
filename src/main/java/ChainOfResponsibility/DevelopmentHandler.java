package ChainOfResponsibility;

public class DevelopmentHandler implements FeedbackHandler {
    private FeedbackHandler nextHandler;

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.DEVELOPMENT) {
            System.out.println("Development feedback: " + message.getMessage());
        } else {
            nextHandler.handleFeedback(message);
        }
    }

    @Override
    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
