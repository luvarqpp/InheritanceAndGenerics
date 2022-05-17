package sk.qpp.tmp.inheritance.simple;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class SimpleFolder {
    private final String folderName;
    private final List<SimpleFolder> folders;
    private final List<SimpleFile> files;

    /**
     * Method can be used to find particular file in {@link SimpleFolder} tree. Returned value is always same,
     * as passed, thus usefulness of this method is only for checking for presence of the file.
     */
    public Optional<SimpleFile> findFileByName(String fileName) {
        // first search in current directory, then use recursion
        return files.stream()
                .filter(fileFromFiles -> 0 == fileFromFiles.getFilename().compareTo(fileName))
                .findAny()
                .or(() ->
                        folders.stream()
                                .map(simpleFolder -> simpleFolder.findFileByName(fileName))
                                .flatMap(Optional::stream)
                                .findFirst()
                );
    }

    public SimpleFolder getParentAccordingPathToFileOrFolder(String path) {
        final String[] pathSegments = path.split("/");
        SimpleFolder currentFolder = this;
        // first part is name of root folder
        for (int i = 1; i < pathSegments.length - 1; i++) {
            final int finalVersionOfI = i;
            currentFolder = currentFolder.getFolders().stream()
                    .filter(f -> 0 == pathSegments[finalVersionOfI].compareTo(f.getFolderName()))
                    .findFirst()
                    .orElse(null);
            if (null == currentFolder) {
                throw new RuntimeException("Folder \"" + pathSegments[finalVersionOfI] + "\" has not been found, when searching for parent folder for path \"" + path + "\". i=" + i);
            }
        }
        return currentFolder;
    }
}
