package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        List<Map<String, Object>> allDate = AllDiffer.dif(dateOne, dateTwo);

        return Formatter.formatter(allDate, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

}
