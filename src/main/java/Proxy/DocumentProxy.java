package Proxy;

import java.util.Date;

public class DocumentProxy implements Document {
    private TheDocument theDocument;
    private AccessControlService accessControlService;

    public DocumentProxy(TheDocument theDocument) {
        this.theDocument = theDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(theDocument.getId(), user.getUsername())) {
            return theDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user " + user.getUsername());
        }
    }

    @Override
    public Date getDate() {
        return theDocument.getDate();
    }

}
