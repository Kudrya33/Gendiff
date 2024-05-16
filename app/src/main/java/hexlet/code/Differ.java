package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static void generate() throws Exception {
        String result = "";

        ObjectMapper mapper = new ObjectMapper();

        String readFileFirst = "/home/pavel/java-project-71/app/file1.json";
        String readFileLast = "/home/pavel/java-project-71/app/file2.json";

        Path first = Paths.get(readFileFirst).toAbsolutePath().normalize();
        Path last = Paths.get(readFileLast).toAbsolutePath().normalize();

        if (!Files.exists(first)) {
            throw new Exception("File '" + first + "' does not exist");
        }
        if (!Files.exists(last)) {
            throw new Exception("File '" + last + "' does not exist");
        }

        File contentFirstFile = new File(String.valueOf(first));
        File contentLastFile = new File(String.valueOf(last));

        Map<String, String> mapFromFirstFile = mapper.readValue(contentFirstFile, Map.class);
        Map<String, String> mapFromLastFile = mapper.readValue(contentLastFile, Map.class);

    }
}
