package task_1_3_2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String SAVE_DIR = "D://Games//savegames//";
    private static final String ZIP_FILE = "D://Games//savegames//zip.zip";

    public static void main(String[] args) {
        GameProcess game1 = new GameProcess(100, 5, 80, 1000);
        GameProcess game2 = new GameProcess(50, 3, 60, 500);
        GameProcess game3 = new GameProcess(10, 1, 40, 300);
        saveGame(SAVE_DIR + "save1.dat", game1);
        saveGame(SAVE_DIR + "save2.dat", game2);
        saveGame(SAVE_DIR + "save3.dat", game3);
        zipFiles(ZIP_FILE, new String[] {SAVE_DIR + "save1.dat",
                SAVE_DIR + "save2.dat", SAVE_DIR + "save3.dat"});
    }

    public static void saveGame(String fileName, GameProcess game) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String zipFile, String[] files) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (String file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.split("//")[file.split("//").length - 1]);
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new File(file).delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
