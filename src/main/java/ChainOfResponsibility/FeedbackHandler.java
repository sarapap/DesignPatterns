package ChainOfResponsibility;

public interface FeedbackHandler {
    void handleFeedback(Message message);
    void setNextHandler(FeedbackHandler nextHandler);
}
