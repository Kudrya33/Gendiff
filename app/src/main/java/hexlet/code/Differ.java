package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        var stringBuild = new StringBuilder("{\n");

        dateOne.forEach((key, value) -> {
            if (!dateTwo.containsKey(key)) {
                stringBuild.append(" - " + key + ": " + value + "\n");
            }
            if (dateTwo.containsKey(key) && dateTwo.containsValue(value)) {
                stringBuild.append("   " + key + ": " + value + "\n");
            }
            if (dateTwo.containsKey(key) && !dateTwo.containsValue(value)) {
                stringBuild.append(" - " + key + ": " + value + "\n");
                stringBuild.append(" + " + key + ": " + dateTwo.get(key) + "\n");
            }
        });

        dateTwo.forEach((key, value) -> {
            if (!dateOne.containsKey(key)) {
                stringBuild.append(" + " + key + ": " + dateTwo.get(key) + "\n");
            }
        });
        stringBuild.append("}");
        String result = stringBuild.toString();
        return result;
    }
}
