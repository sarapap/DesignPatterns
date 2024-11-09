package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    @Override
    public void buildProcessor() {
        this.processor = "Intel i5";
    }

    @Override
    public void buildRAM() {
        this.ramSize = 16;
    }

    @Override
    public void buildHardDrive() {
        this.hardDrive = "512 GB SSD";
    }

    @Override
    public void buildGraphicsCard() {
        this.graphicsCard = "Integrated Graphics";
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

