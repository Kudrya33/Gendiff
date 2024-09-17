package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String data1 = getData(filepath1);
        String data2 = getData(filepath2);

        String fileType1 = getType(filepath1);
        String fileType2 = getType(filepath2);

        var parserlist = Parser.pars(data1, data2, fileType1, fileType2);
        Map<String, Object> dateOne = parserlist.get(0);
        Map<String, Object> dateTwo = parserlist.get(1);
        List<Map<String, Object>> allDate = AllDiffer.allChanges(dateOne, dateTwo);

        return Formatter.formatter(allDate, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getData(String filepath) throws Exception {
        Path path = Paths.get(filepath.substring(filepath.indexOf("src")));
        return Files.readString(path);
    }

    private static String getType(String filePath) {
        return filePath.substring(filePath.indexOf(".") + 1);
    }
}
