package sk.qpp.tmp.generics.extended;

import sk.qpp.tmp.generics.simple.GSimpleFile;

public class ExtendedGSimpleFile extends GSimpleFile {
    private final String additionalNote;

    public ExtendedGSimpleFile(String filename, String additionalNote) {
        super(filename);
        this.additionalNote = additionalNote;
    }
}
