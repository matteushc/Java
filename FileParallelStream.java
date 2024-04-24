import java.util.*;
import java.util.stream.*;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.files.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import java.nio.charset.Charset;
import java.io.File;
import java.io.FileWriter;

public class FileParallelStream {

    public static void main(String[] args) throws IOException {

        File[] directories = new File("PATH_DIRECTORY").listFiles(File::isDirectory);

        for (File dir : directories) {
            System.out.println(dir.getName());
            File[] files = new File(dir.getPath()).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    List<String> results = new ArrayList<String>();
                    System.out.println(file.getName());
                    Path pathRepo = Paths.get("PATH_DIRECTORY_REPOSITORY");
                    long timeA = System.currentTimeMillis();
                    Stream<Path> stream = Files.walk(pathRepo);
                    stream.parallel().filter(p -> !p.toString().contains(".git"))
                        .filter(p -> p.getFileName().toString().endsWith(".java"))
                        .filter(Files::isRegularFile)
                        .forEach(filePath -> {
                            try (Stream<String> lines = Files.lines(filePath)) {
                                lines.filter(line -> line.contains("TEXT_SEARCH")).findAny().
                                ifPresent(matchingLine -> {
                                    results.add(filePath.toString());
                                });
                            } catch (Exception e) {
                                
                            }
                        });
                    System.out.println(System.currentTimeMillis() - timeA);
                    FileWriter fw = new FileWriter(file.getPath(), true);
                    for (String str : results) {
                        fw.write(str + System.lineSeparator());
                    }
                    fw.close();
                }
            }
        }
    }

}
