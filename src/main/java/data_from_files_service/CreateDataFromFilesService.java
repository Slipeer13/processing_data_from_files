package data_from_files_service;

public class CreateDataFromFilesService {

    public static DataFromFilesService<? extends Comparable<?>> getDataFromFilesService(String value) throws IllegalArgumentException {
        switch (value) {
            case "-i" : return new DataFromFilesIntegerService();
            case "-s" : return new DataFromFilesStringService();
            default: throw new IllegalArgumentException("нет такого типа данных: " + value);
        }
    }

}
