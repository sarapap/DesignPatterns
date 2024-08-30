package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        Button buttonA = factoryA.createButton("OK");
        TextField textFieldA = factoryA.createTextField("Text here");
        Checkbox checkboxA = factoryA.createCheckbox("Click me");

        Button buttonB = factoryB.createButton("Submit");
        TextField textFieldB = factoryB.createTextField("Search...");
        Checkbox checkboxB = factoryB.createCheckbox("Agree");

        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        buttonA.setText("Cancel");
        buttonA.display();

        buttonB.display();
        textFieldB.display();
        checkboxB.display();
    }
}
