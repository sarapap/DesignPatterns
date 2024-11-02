package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addRealDocument(Document document, String id) {
        documents.put(id, document);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }

    public void addProtectedDocument(String documentId, String content, String username) {
        TheDocument realDocument = new TheDocument(documentId, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        AccessControlService.getInstance().setPermission(documentId, username);
        addRealDocument(proxy, documentId);
    }
}
