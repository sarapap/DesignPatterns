package Builder;

public class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public Computer(String processor, int ramSize, String hardDrive, String graphicsCard, String operatingSystem) {
        this.processor = processor;
        this.ramSize = ramSize;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
        .append("Processor: ").append(processor).append("\n")
        .append("RAM Size: ").append(ramSize).append(" GB\n")
        .append("Hard Drive: ").append(hardDrive).append("\n")
        .append("Graphics Card: ").append(graphicsCard).append("\n")
        .append("Operating System: ").append(operatingSystem);
        return sb.toString();
    }
}
