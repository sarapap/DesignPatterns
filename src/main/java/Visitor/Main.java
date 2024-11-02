package Visitor;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("text.txt", 1.2);
        File file2 = new File("image.jpg", 2.5);
        File file3 = new File("presentation.ppt", 20.0);
        File file4 = new File("text2.txt", 0.8);

        Directory directory1 = new Directory("Directory 1");
        Directory directory2 = new Directory("Directory 2");

        directory1.addElement(file1);
        directory1.addElement(file2);
        directory2.addElement(file3);
        directory2.addElement(file4);

        directory1.addElement(directory2);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        directory1.haveVisitor(sizeCalculator);
        System.out.println("Total size of files: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        directory1.haveVisitor(searchVisitor);
        System.out.println("All files: " + file1.getName() + ", " + file2.getName() + ", " + file3.getName() + ", " + file4.getName());
        System.out.println("Matching files:");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + file.getName());
        }
    }
}

