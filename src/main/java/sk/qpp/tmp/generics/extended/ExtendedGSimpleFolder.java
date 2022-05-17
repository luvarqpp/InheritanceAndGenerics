package sk.qpp.tmp.generics.extended;

import sk.qpp.tmp.generics.simple.GSimpleFile;
import sk.qpp.tmp.generics.simple.GSimpleFolder;

import java.util.List;

public class ExtendedGSimpleFolder extends GSimpleFolder<ExtendedGSimpleFolder, ExtendedGSimpleFile> {
    private final String someAdditionalInfoForFolder;

    public ExtendedGSimpleFolder(String folderName, List<ExtendedGSimpleFolder> folders, List<ExtendedGSimpleFile> files, String someAdditionalInfoForFolder) {
        super(folderName, folders, files);
        this.someAdditionalInfoForFolder = someAdditionalInfoForFolder;
    }
}
