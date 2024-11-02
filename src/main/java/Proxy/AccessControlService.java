package Proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Set<String> permissions;

    private AccessControlService() {
        permissions = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void setPermission(String user, String document) {
        permissions.add(user + ":" + document);
    }

    public boolean isAllowed(String user, String document) {
        return permissions.contains(user + ":" + document);
    }
}
