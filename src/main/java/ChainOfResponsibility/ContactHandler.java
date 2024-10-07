package ChainOfResponsibility;

public class ContactHandler implements FeedbackHandler {
    private FeedbackHandler nextHandler;

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.CONTACT) {
            System.out.println("Contact Handler: " + message.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }

    @Override
    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
