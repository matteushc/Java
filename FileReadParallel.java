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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadParallel {

    public static void main(String[] args) throws IOException {

        String valueFound = "";
        String repoName = ""
        Path pathRepo = Paths.get(repoName);
        long timeA = System.currentTimeMillis();
        Stream<Path> stream = Files.walk(pathRepo);
        stream.parallel().filter(p -> !p.toString().contains(".idea") && !p.toString().contains(".git"))
            .filter(p -> 
                //p.getFileName().toString().endsWith(".py") 
                p.getFileName().toString().endsWith(".java") 
                || p.getFileName().toString().endsWith(".sql")
                || p.getFileName().toString().endsWith(".hql")
                || p.getFileName().toString().endsWith(".xml")
                //|| p.getFileName().toString().endsWith(".json")
            )
            .filter(Files::isRegularFile)
            .forEach(filePath -> {
                try (Stream<String> lines = Files.lines(filePath)) {
                    lines.filter(line -> line.contains(valueFound)).findAny().
                    ifPresent(matchingLine -> {
                        System.out.println(filePath);
                    });
                } catch (Exception e) {
                    
                }
            });
        System.out.println(System.currentTimeMillis() - timeA);
    }

}
