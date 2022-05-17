package sk.qpp.tmp.inheritance.extended;

import org.junit.jupiter.api.Test;

import java.util.List;

class ExtendedSimpleFolderTest {
    @Test
    public void testWithWrongResultDueToInheritance() {
        final ExtendedSimpleFolder rootFolder = new ExtendedSimpleFolder(
                "rootFolder",
                "additional data",
                List.of(new ExtendedSimpleFolder(
                        "asdf",
                        "extendedFolderData",
                        List.of(),
                        List.of(new ExtendedSimpleFile("someFilename.java", "extended thing"))
                )),
                List.of(new ExtendedSimpleFile("asdf.txt", "secret file"))
        );

        // findFileByName is using its private final lists, where no data is placed. See ExtendedSimpleFolder constructor and see passing empty lists.
        System.out.println("Search for asdf.txt -> " + rootFolder.findFileByName("asdf.txt"));
        System.out.println("Search for payments.rb -> " + rootFolder.findFileByName("payments.rb"));
        System.out.println("Search for someFilename.java -> " + rootFolder.findFileByName("someFilename.java"));
    }
}