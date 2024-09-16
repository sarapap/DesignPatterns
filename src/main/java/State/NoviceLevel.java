package State;

public class NoviceLevel implements CharacterState {
    private GameCharacter gameCharacter;

    public NoviceLevel(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public void train() {
        System.out.println("Training...");
        gameCharacter.increaseExperiencePoints(50);
    }

    @Override
    public void meditate() {
        System.out.println("You can't meditate at Novice level.");
    }

    @Override
    public void fight() {
        System.out.println("You can't fight at Novice level.");
    }

}
