package State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);
        character.displayStatus();

        while (!(character.getState() instanceof MasterLevel)) {
            System.out.println("Choose an action: 1) Train 2) Meditate 3) Fight");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            character.displayStatusBetween();
        }

        System.out.println("Game over!");
        scanner.close();
    }
}

