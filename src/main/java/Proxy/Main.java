package Proxy;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TheDocument document1 = new TheDocument("PublicDocument", "Public content for everyone");
        library.addRealDocument(document1, "PublicDocument");

        library.addProtectedDocument("SensitiveDocument", "Sensitive content, not for everyone", "PermissionUser");

        User user1 = new User("PermissionUser");
        User user2 = new User("NoPermissionUser");

        try {
            System.out.println("Document: " + "Public Document");
            System.out.println("Creation Date: " + dateFormat.format(library.getDocument("PublicDocument").getDate()));
            System.out.println("PermissionUser accessing Public Document: " + library.getDocument("PublicDocument").getContent(user1));
            System.out.println("NoPermissionUser accessing Public Document: " + library.getDocument("PublicDocument").getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nDocument: " + "Sensitive Document");
            System.out.println("Creation Date: " + dateFormat.format(library.getDocument("PublicDocument").getDate()));
            System.out.println("PermissionUser accessing Sensitive Document: " + library.getDocument("SensitiveDocument").getContent(user1));
            System.out.println("NoPermissionUser accessing Sensitive Document: " + library.getDocument("SensitiveDocument").getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
