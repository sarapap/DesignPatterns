package ChainOfResponsibility;

public class CompensationHandler implements FeedbackHandler {
    private FeedbackHandler nextHandler;

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION) {
            System.out.println("Compensation Handler: " + message.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }

    @Override
    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
