package create_data_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CreateOutputFile {
    public static void createOutputFile(String nameOutputFile, List<?> sortingList) throws IOException {
        Path path = Paths.get(nameOutputFile);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        List<String> lines = sortingList.stream().map(String::valueOf).collect(Collectors.toList());
        Files.write(path, lines);
    }
}
