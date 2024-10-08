package ChainOfResponsibility;

public class Message {
    private MessageType messageType;
    private String message;
    private String senderEmail;

    public Message(MessageType messageType, String message, String senderEmail) {
        this.messageType = messageType;
        this.message = message;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}
