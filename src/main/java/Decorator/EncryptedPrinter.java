package Decorator;

public class EncryptedPrinter implements Printer {
    private Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encryptMessage(message);
        printer.print(encryptedMessage);
    }

    private String encryptMessage(String message) {
        StringBuilder encrypted = new StringBuilder();
        int shift = 3;

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }
}
