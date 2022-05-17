package sk.qpp.tmp.generics.simple;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
// Why does simple commenting out of generics make code compilable? Intention is to use F generics for list of folders attribute and S for files
// public class SimpleFolder {
public class GSimpleFolder<F extends GSimpleFolder, S extends GSimpleFile> {
    private final String folderName;
    //private final List<GSimpleFolder> folders;
    //private final List<GSimpleFile> files;
    private final List<F> folders;
    private final List<S> files;

    public Optional<GSimpleFile> findFileByName(String fileName) {
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

    public GSimpleFolder getParentAccordingPathToFileOrFolder(String path) {
        final String[] pathSegments = path.split("/");
        GSimpleFolder currentFolder = this;
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
