package create_data_service;

import data_from_files_service.DataFromFilesService;
import sorting.DirectSorting;
import sorting.MergeSort;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CreateSortingList {

    public static<T extends Comparable<T>> List<?> getSortingList(DirectSorting directSorting, DataFromFilesService<T> dataFromFilesService
            , List<Path> paths) throws IOException {
        List<T> list = dataFromFilesService.getList(paths);
        MergeSort.directSorting = directSorting;
        MergeSort.mergeSort(list);
        return list;

    }


}
