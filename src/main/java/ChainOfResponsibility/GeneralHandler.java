package ChainOfResponsibility;

public class GeneralHandler implements FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.GENERAL) {
            System.out.println("General feedback: " + message.getMessage());
        } else {
            nextHandler.handleFeedback(message);
        }
    }

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
