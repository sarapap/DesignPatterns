package State;

public class ExpertLevel implements CharacterState {
    private GameCharacter gameCharacter;

    public ExpertLevel(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        gameCharacter.level = 3;
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
        System.out.println("Fighting...");
        gameCharacter.increaseExperiencePoints(100);
        gameCharacter.decreaseHealth(30);
    }

}
