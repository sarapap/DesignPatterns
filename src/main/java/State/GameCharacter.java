package State;

import java.util.Random;

public class GameCharacter {
    private String name;
    public int level;
    private int experiencePoints;
    private int healthPoints;
    private CharacterState state;
    private Random random;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.state = new NoviceLevel(this);
        this.random = new Random();
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public CharacterState getState() {
        return state;
    }

    public int getHealth() {
        return healthPoints;
    }

    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void increaseExperiencePoints(int points) {
        this.experiencePoints += points;
        checkLevel();
    }

    public void increaseHealth(int points) {
        int hp = random.nextInt(10, 30);
        healthPoints += hp;
    }

    public void decreaseHealth(int points) {
        int hp = random.nextInt(10, 30);
        healthPoints -= hp;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }

    public void checkLevel() {
        if (experiencePoints >= 100 && level == 1) {
            setState(new IntermediateLevel(this));
            System.out.println("You've reached Intermediate level!");
        } else if (experiencePoints >= 200 && level == 2) {
            setState(new ExpertLevel(this));
            System.out.println("You've reached Expert level!");
        } else if (experiencePoints >= 500 && level == 3) {
            setState(new MasterLevel(this));
            System.out.println("You've reached Master level!");
        }
    }

    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience Points: " + experiencePoints);
        System.out.println("Health Points: " + healthPoints);
        System.out.println();
    }

    public void displayStatusBetween() {
        System.out.println("Level: " + level);
        System.out.println("Experience Points: " + experiencePoints);
        System.out.println("Health Points: " + healthPoints);
        System.out.println();
    }
}
