package ChainOfResponsibility;

public class Message {
    private MessageType messageType;
    private String message;
    private String sender;

    public Message(MessageType messageType, String message, String sender) {
        this.messageType = messageType;
        this.message = message;
        this.sender = sender;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
