import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * @author Oleh Marych
 */
public class UnitTests {

    @Test
    public void testTask1() {
        int filesCount = 2;
        int threshold = 1;
        int emptyFilesCount = 4;
        int fullFilesCount = 3;

        try {
            Path temp = Files.createTempDirectory("task1");
            Path out = Files.createTempDirectory("out");
            createFilesInDir(temp, emptyFilesCount, fullFilesCount);

            System.out.println("Run method");
            Handler.handleTask1(temp.toString(), filesCount, threshold, out.toString());

            assertEquals(Objects.requireNonNull(new File(temp.toUri()).list()).length, filesCount);
            assertEquals(Objects.requireNonNull(new File(out.toUri()).list()).length, emptyFilesCount + fullFilesCount - filesCount);
            System.out.println("Clean up");
            deleteDirectory(new File(temp.toUri()));
            deleteDirectory(new File(out.toUri()));
        } catch (IOException e) {
            System.out.println("Error with creating files");
            fail();
        }
    }

    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    private void createFilesInDir(Path dir, int emptyFiles, int fullFiles) throws IOException {
        File dirFile = new File(dir.toUri());
        for (int i = 0; i < emptyFiles; i++) {
            File file = new File(dirFile, "emptyFile" + i + ".txt");
            file.createNewFile();
        }
        for (int i = 0; i < fullFiles; i++) {
            File file = new File(dirFile, "fullFile" + i + ".txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Some text that has more than 1 byte");
            fileWriter.close();
        }
    }


    @Test
    public void testTask2() {
        try {
            Path temp = Files.createTempDirectory("task2");
            Pair<String, Integer> dirs = createDirs(temp);

            System.out.println("Run method");
            Pair<String, Integer> handle = Handler.handleTask2(temp.toString());

            assertEquals(handle.getKey(), dirs.getKey());
            assertEquals(handle.getValue(), dirs.getValue());
        } catch (IOException e) {
            System.out.println("Error with creating temp directory");
            fail();
        }
    }

    @After
    public void cleanup() {
        System.out.println("Clean Up");
        deleteDirectory(new File("/Users/admin/IdeaProjects/demo-simple/src/resources/"));
    }

    private Pair<String, Integer> createDirs(Path dir) {
        String sub_4 = dir + "/sub1/sub4";
        String sub_5 = dir + "/sub1/sub5";
        String sub_6 = dir + "/sub2/sub6";
        String sub_7 = dir + "/sub3/sub7";
        String sub_8 = dir + "/sub3/sub8";
        String sub_9 = dir + "/sub3/sub9";
        String sub_10 = dir + "/sub3/sub10";
        String sub_11 = sub_4 + "/sub11";
        String sub_12 = sub_4 + "/sub12";

        new File(sub_4).mkdirs();
        new File(sub_5).mkdirs();
        new File(sub_6).mkdirs();
        new File(sub_7).mkdirs();
        new File(sub_8).mkdirs();
        new File(sub_9).mkdirs();
        new File(sub_10).mkdirs();
        new File(sub_11).mkdirs();
        new File(sub_12).mkdirs();

        return new Pair<>("sub3", 4);
    }
}