package controller;

import create_data_service.CreateOutputFile;
import create_data_service.CreateSortingList;
import create_data_service.DataArgumentService;
import data_from_files_service.DataFromFilesService;
import sorting.DirectSorting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ControllerCreateSortingFile {
    public static void createSortingFile(String[] args) {
        DataArgumentService dataArgumentService = new DataArgumentService(args);
        String params = "1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;\n" +
                "2. тип данных (-s или -i), обязательный;\n" +
                "3. имя выходного файла, обязательное;\n" +
                "4. остальные параметры – имена входных файлов, не менее одного.";
        try {
            DirectSorting directSorting = dataArgumentService.getDirectSorting();
            DataFromFilesService<?> dataFromFilesService = dataArgumentService.getFromFilesService();
            String nameOutputFile = dataArgumentService.getNameOutputFile();
            List<Path> paths = dataArgumentService.getPaths();
            List<?> sortingList = CreateSortingList.getSortingList(directSorting, dataFromFilesService, paths);
            CreateOutputFile.createOutputFile(nameOutputFile, sortingList);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | IOException e) {
            if(e instanceof ArrayIndexOutOfBoundsException) System.out.printf("введите параметры:\n%s", params);
            if(e instanceof IllegalArgumentException) System.out.println("тип данных должен быть -i или -d");
            if(e instanceof IOException) System.out.printf("не получилось записать по причине %s", e.getMessage());
        }
    }
}
