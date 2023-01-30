package create_data_service;

import data_from_files_service.CreateDataFromFilesService;
import data_from_files_service.DataFromFilesService;
import sorting.DirectSorting;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataArgumentService {

    private final String[] args;

    public DataArgumentService(String[] args) {
        this.args = args;
    }

    public DirectSorting getDirectSorting() {
        return DirectSorting.getDirect(args[0]);
    }

    public DataFromFilesService<?> getFromFilesService() {
        if (!args[0].equals("-a") && !args[0].equals("-d")) {
            return CreateDataFromFilesService.getDataFromFilesService(args[0]);
        } else {
            return CreateDataFromFilesService.getDataFromFilesService(args[1]);
        }
    }

    public String getNameOutputFile() {
        if (!args[0].equals("-a") && !args[0].equals("-d")) {
            return args[1];
        } else {
            return args[2];
        }
    }

    public List<Path> getPaths() {
        List<Path> paths = new ArrayList<>();
        if (!args[0].equals("-a") && !args[0].equals("-d")) {
            for (int i = 2; i < args.length; i++) {
                Path path = Paths.get(args[i]);
                paths.add(path);
            }
        } else {
            for (int i = 3; i < args.length; i++) {
                Path path = Paths.get(args[i]);
                paths.add(path);
            }
        }
        return paths;
    }
}
