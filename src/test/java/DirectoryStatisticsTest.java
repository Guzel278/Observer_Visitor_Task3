import java.io.File;

public class DirectoryStatisticsTest {
    public static void main(String[] args) {
        // Создаем директорию
        File rootDirectoryFile = new File("/Users/guzelganieva/Downloads");
        MyDirectory rootDirectory = new MyDirectory(rootDirectoryFile.getName(), rootDirectoryFile);
        Element[] arrFiles  = rootDirectory.getChildren();
        // Создаем объект статистики
        DirectoryStatistics directoryStatistics = new DirectoryStatistics();
        rootDirectory.accept(directoryStatistics); // Первичное вычисление статистики

        // Выводим статистику
        for (Element file: arrFiles) {
            System.out.println("Directory: " + file);
        }
        System.out.println("File Count: " + directoryStatistics.getFileCount());
        System.out.println("Total Size: " + directoryStatistics.getTotalSize() + " bytes");
    }
}
