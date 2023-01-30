package data_from_files_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataFromFilesIntegerService implements DataFromFilesService<Integer> {

    @Override
    public List<Integer> getList(List<Path> paths) throws IOException {
        List<Integer> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        for (Path p:
                paths) {
            List<Integer> listInteger = Files.readAllLines(p).stream().filter(x -> pattern.matcher(x).matches())
                    .map(Integer::parseInt).collect(Collectors.toList());
            list.addAll(listInteger);
        }
        return list;
    }
}
