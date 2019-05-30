import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handler {
    public static void handleTask1(String startedDir, int filesCount, int threshold, String endDir) {
        int counter = 0;
        File fileDir = new File(startedDir);
        File[] files = fileDir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.length() <= threshold && counter < filesCount) {
                counter++;
            } else {
                file.renameTo(new File(endDir + "/" + file.getName()));
            }
        }
    }

    public static Pair<String, Integer> handleTask2(String startedDir) {
        final int[] maxNumber = {0};
        final String[] maxName = {startedDir};

        try {
            Files.walk(Paths.get(startedDir))
                    .forEach(x -> {
                        File file = x.toFile();
                        if (!file.isDirectory())
                            return;
                        File[] subdirs = file.listFiles(File::isDirectory);
                        assert subdirs != null;
                        if (subdirs.length > maxNumber[0]) {
                            maxNumber[0] = subdirs.length;
                            maxName[0] = file.getName();
                        }
                    });
            return new Pair<>(maxName[0], maxNumber[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
