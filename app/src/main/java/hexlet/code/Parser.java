package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static String pars(String filepath1, String filepath2, String format) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String one = "file1.yml";
        String two = "file2.yml";

        Path first = Paths.get(one).toAbsolutePath().normalize();
        Path last = Paths.get(two).toAbsolutePath().normalize();

        if (!Files.exists(first)) {
            throw new Exception("File '" + first + "' does not exist");
        }
        if (!Files.exists(last)) {
            throw new Exception("File '" + last + "' does not exist");
        }

        File contentFirstFile = new File(String.valueOf(first));
        File contentLastFile = new File(String.valueOf(last));

        Map<String, Object> mapFromFirstFile = mapper.readValue(contentFirstFile, Map.class);
        Map<String, Object> mapFromLastFile = mapper.readValue(contentLastFile, Map.class);
        Map<String, Object> sortFirstFile = new TreeMap<>(mapFromFirstFile);
        Map<String, Object> sortLastFile = new TreeMap<>(mapFromLastFile);

        var result = new StringBuilder("{\n");

        sortFirstFile.forEach((key, value) -> {
            if (!sortLastFile.containsKey(key)) {
                result.append(" - " + key + ": " + value + "\n");
            }
            if (sortLastFile.containsKey(key) && sortLastFile.containsValue(value)) {
                result.append("   " + key + ": " + value + "\n");
            }
            if (sortLastFile.containsKey(key) && !sortLastFile.containsValue(value)) {
                result.append(" - " + key + ": " + value + "\n");
                result.append(" + " + key + ": " + sortLastFile.get(key) + "\n");
            }
        });

        sortLastFile.forEach((key, value) -> {
            if (!sortFirstFile.containsKey(key)) {
                result.append(" + " + key + ": " + sortLastFile.get(key) + "\n");
            }
        });
        result.append("}");
        return result.toString();
    }
}
