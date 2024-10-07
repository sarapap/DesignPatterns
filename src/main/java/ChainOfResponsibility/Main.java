package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactHandler();
        FeedbackHandler suggestionHandler = new DevelopmentHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        Message feedback1 = new Message(MessageType.COMPENSATION, "Claim for refund", "customer@example.com");
        Message feedback2 = new Message(MessageType.CONTACT, "Need assistance with my order", "customer@example.com");
        Message feedback3 = new Message(MessageType.DEVELOPMENT, "Add dark mode feature", "customer@example.com");
        Message feedback4 = new Message(MessageType.GENERAL, "Great service!", "customer@example.com");

        compensationHandler.handleFeedback(feedback1);
        compensationHandler.handleFeedback(feedback2);
        compensationHandler.handleFeedback(feedback3);
        compensationHandler.handleFeedback(feedback4);
    }
}
