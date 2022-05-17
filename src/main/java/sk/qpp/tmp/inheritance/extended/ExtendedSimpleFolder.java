package sk.qpp.tmp.inheritance.extended;

import sk.qpp.tmp.inheritance.simple.SimpleFolder;

import java.util.List;

public class ExtendedSimpleFolder extends SimpleFolder {
    private final String anotherExtension;

    private final List<ExtendedSimpleFolder> folders;
    private final List<ExtendedSimpleFile> files;

    public ExtendedSimpleFolder(String folderName, String anotherExtension, List<ExtendedSimpleFolder> folders1, List<ExtendedSimpleFile> files1) {
        // pass empty, immutable, list instances to parent class
        super(folderName, List.of(), List.of());
        this.anotherExtension = anotherExtension;
        this.folders = folders1;
        this.files = files1;
    }
}
