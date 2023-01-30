package data_from_files_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataFromFilesStringService implements DataFromFilesService<String> {
    @Override
    public List<String> getList(List<Path> paths) throws IOException {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\S+");
        for (Path p:
                paths) {
            List<String> listString = Files.readAllLines(p).stream()
                    .filter(x -> pattern.matcher(x).matches()).collect(Collectors.toList());
            list.addAll(listString);
        }
        return list;
    }
}
