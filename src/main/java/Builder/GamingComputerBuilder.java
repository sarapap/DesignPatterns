package Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    @Override
    public void buildProcessor() {
        this.processor = "Intel i9";
    }

    @Override
    public void buildRAM() {
        this.ramSize = 32;
    }

    @Override
    public void buildHardDrive() {
        this.hardDrive = "1 TB SSD";
    }

    @Override
    public void buildGraphicsCard() {
        this.graphicsCard = "NVIDIA GeForce RTX 3080";
    }

    @Override
    public void buildOperatingSystem() {
        this.operatingSystem = "Windows 10";
    }

    @Override
    public Computer getComputer() {
        return new Computer(processor, ramSize, hardDrive, graphicsCard, operatingSystem);
    }
}
