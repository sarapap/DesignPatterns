package Mediator;

import java.util.*;

public class ChatMediator {
    private final Map<String, ChatUser> clients = new HashMap<>();

    public void register(ChatUser client) {
        clients.put(client.getName(), client);
        updateAllReceivers();
    }

    public void sendMessage(String message, String sender, String receiver) {
        ChatUser client = clients.get(receiver);
        if (client != null) {
            client.receive(message, sender);
        }
    }

    public String[] getUsernames() {
        return clients.keySet().toArray(new String[0]);
    }

    private void updateAllReceivers() {
        String[] usernames = getUsernames();
        for (ChatUser client : clients.values()) {
            client.updateReceivers(usernames);
        }
    }
}

