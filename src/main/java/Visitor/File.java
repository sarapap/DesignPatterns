package Visitor;

public class File implements FileSystemElement {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public void haveVisitor(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
