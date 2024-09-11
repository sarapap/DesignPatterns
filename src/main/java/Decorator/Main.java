package Decorator;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("This assignment is fun!");

        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("This assignment is fun!");
    }
}
