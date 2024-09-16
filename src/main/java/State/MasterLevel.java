package State;

public class MasterLevel implements CharacterState {
    private GameCharacter gameCharacter;

    public MasterLevel(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        gameCharacter.level = 4;
    }

    @Override
    public void train() {
        System.out.println("You are already a Master. You don't need to train anymore.");
    }

    @Override
    public void meditate() {
        System.out.println("You are already a Master. You don't need to meditate anymore.");
    }

    @Override
    public void fight() {
        System.out.println("You are already a Master. You don't need to fight anymore.");
    }

}
