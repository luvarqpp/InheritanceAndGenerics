package sk.qpp.tmp.inheritance.extended;

import lombok.Getter;
import sk.qpp.tmp.inheritance.simple.SimpleFile;

@Getter
public class ExtendedSimpleFile extends SimpleFile {
    private final String someExtendedFunctionality;

    public ExtendedSimpleFile(String filename, String someExtendedFunctionality) {
        super(filename);
        this.someExtendedFunctionality = someExtendedFunctionality;
    }
}
