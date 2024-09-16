package State;

public class IntermediateLevel implements CharacterState {
    private GameCharacter gameCharacter;

    public IntermediateLevel(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        gameCharacter.level = 2;
    }

    @Override
    public void train() {
        System.out.println("Training...");
        gameCharacter.increaseExperiencePoints(50);
    }

    @Override
    public void meditate() {
        System.out.println("Meditating...");
        gameCharacter.increaseHealth(20);
    }


    @Override
    public void fight() {
        System.out.println("You can't fight at Intermediate level.");
    }

}
