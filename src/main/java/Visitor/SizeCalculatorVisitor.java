package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.haveVisitor(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}

