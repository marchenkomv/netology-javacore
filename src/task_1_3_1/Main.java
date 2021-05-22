package task_1_3_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private static final String ROOT_DIR = "D://Games//";
    private static final String LOG_PATH = ROOT_DIR + "temp//temp.txt";
    private static StringBuilder Logger = new StringBuilder();

    public static void main(String[] args) {
        createFileOrDirectory(ROOT_DIR + "test", false);
        createFileOrDirectory(ROOT_DIR + "res", false);
        createFileOrDirectory(ROOT_DIR + "savegames", false);
        createFileOrDirectory(ROOT_DIR + "temp", false);
        createFileOrDirectory(ROOT_DIR + "src", false);
        createFileOrDirectory(ROOT_DIR + "src//main", false);
        createFileOrDirectory(ROOT_DIR + "src//test", false);
        createFileOrDirectory(ROOT_DIR + "res//drawables", false);
        createFileOrDirectory(ROOT_DIR + "res//vectors", false);
        createFileOrDirectory(ROOT_DIR + "res//icons", false);
        createFileOrDirectory(ROOT_DIR + "src//main//Main.java", true);
        createFileOrDirectory(ROOT_DIR + "src//main//Utils.java", true);
        createFileOrDirectory(ROOT_DIR + "temp//temp.txt", true);
        writeLog(Logger.toString());
    }

    public static void createFileOrDirectory(String name, boolean isFile) {
        if (isFile) {
            try {
                if (new File(name).createNewFile()) {
                    Logger.append("File " + name + " has been successfully created\n");
                } else {
                    Logger.append("File " + name + " already exists\n");
                }
            } catch (IOException e) {
                Logger.append("File " + name + " was not created. Error: "
                        + e.getMessage() + "\n");
            }
        } else {
            if (new File(name).mkdir()) {
                Logger.append("Directory " + name + " has been successfully created\n");
            } else {
                Logger.append("Directory " + name + " already exists\n");
            }
        }
    }

    public static void writeLog(String log) {
        try (FileOutputStream fos = new FileOutputStream(LOG_PATH)) {
            fos.write(log.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
