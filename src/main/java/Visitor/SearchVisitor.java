package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String criteria;
    private List<File> matchFiles;

    public SearchVisitor(String criteria) {
        this.criteria = criteria;
        this.matchFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(criteria)) {
            matchFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.haveVisitor(this);
        }
    }

    public List<File> getMatchingFiles() {
        return matchFiles;
    }
}

