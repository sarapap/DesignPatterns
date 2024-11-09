package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);
        director1.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);
        director2.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("\nOffice Computer: " + officeComputer);
    }
}
