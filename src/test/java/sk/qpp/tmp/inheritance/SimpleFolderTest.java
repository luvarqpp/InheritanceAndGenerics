package sk.qpp.tmp.inheritance;

import org.junit.jupiter.api.Test;
import sk.qpp.tmp.inheritance.simple.SimpleFile;
import sk.qpp.tmp.inheritance.simple.SimpleFolder;

import java.util.List;

class SimpleFolderTest {
    @Test
    public void testWithExpectedResult() {
        final SimpleFolder rootFolder = new SimpleFolder(
                "rootFolder",
                List.of(new SimpleFolder(
                        "asdf",
                        List.of(),
                        List.of(new SimpleFile("someFilename.java"))
                )),
                List.of(new SimpleFile("asdf.txt"))
        );

        System.out.println("Search for asdf.txt -> " + rootFolder.findFileByName("asdf.txt"));
        System.out.println("Search for payments.rb -> " + rootFolder.findFileByName("payments.rb"));
        System.out.println("Search for someFilename.java -> " + rootFolder.findFileByName("someFilename.java"));
    }
}