package sk.qpp.tmp.inheritance.extended;

import java.util.List;

class ExtendedSimpleFolderTest {
    public void firstTest() {
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

        System.out.println("Search for asdf.txt -> " + rootFolder.findFileByName("asdf.txt"));
        System.out.println("Search for payments.rb -> " + rootFolder.findFileByName("payments.rb"));
        System.out.println("Search for someFilename.java -> " + rootFolder.findFileByName("someFilename.java"));
    }
}