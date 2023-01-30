package data_from_files_service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DataFromFilesService<T extends Comparable<T>> {
    List<T> getList(List<Path> paths) throws IOException;
}
