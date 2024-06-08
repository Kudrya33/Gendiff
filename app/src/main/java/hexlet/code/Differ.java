package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path firstFile = Paths.get(filepath1).toAbsolutePath().normalize();
        Path lastFile = Paths.get(filepath2).toAbsolutePath().normalize();

        if (!Files.exists(firstFile)) {
            throw new Exception("File '" + filepath1 + "' does not exist");
        }
        if (!Files.exists(lastFile)) {
            throw new Exception("File '" + filepath2 + "' does not exist");
        }

        var parserlist = Parser.pars(firstFile, lastFile);
        Map<String, Object> dateOne = parserlist.get(0);
        Map<String, Object> dateTwo = parserlist.get(1);
        Map<String, List<Object>> allDate = new HashMap<>();

        dateOne.forEach((key, value) -> {
            if (value == null) {
                value = "null";
                dateOne.put(key, value);
            }
        });

        dateTwo.forEach((key, value) -> {
            if (value == null) {
                value = "null";
                dateTwo.put(key, value);
            }
        });

        dateOne.forEach((key, value) -> {
            if (!dateTwo.containsKey(key)) {
                List<Object> values = new ArrayList<>();
                values.add(value);
                allDate.put(key, values);
            }
            if (dateTwo.containsKey(key) && dateTwo.get(key).equals(value)) {
                List<Object> values = new ArrayList<>();
                values.add(value);
                allDate.put(key, values);
            }
            if (dateTwo.containsKey(key) && !dateTwo.get(key).equals(value)) {
                List<Object> values = new ArrayList<>();
                Object valueDateTwo = dateTwo.get(key);
                values.add(value);
                values.add(valueDateTwo);
                allDate.put(key, values);
            }
        });

        dateTwo.forEach((key, value) -> {
            if (!dateOne.containsKey(key)) {
                List<Object> values = new ArrayList<>();
                values.add(value);
                allDate.put(key, values);
            }
        });
        return Formatter.formatter(allDate, dateOne, dateTwo, format);
    }
}
