package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path firstFile = Paths.get(filepath1).toAbsolutePath().normalize();
        Path lastFile = Paths.get(filepath2).toAbsolutePath().normalize();

        String fileType1 = getType(filepath1);
        String fileType2 = getType(filepath2);

        File contentFirstFile = new File(String.valueOf(firstFile));
        File contentLastFile = new File(String.valueOf(lastFile));

        if (!Files.exists(firstFile)) {
            throw new Exception("File '" + filepath1 + "' does not exist");
        }
        if (!Files.exists(lastFile)) {
            throw new Exception("File '" + filepath2 + "' does not exist");
        }

        var parserlist = Parser.pars(contentFirstFile, contentLastFile, fileType1, fileType2);
        Map<String, Object> dateOne = parserlist.get(0);
        Map<String, Object> dateTwo = parserlist.get(1);
        List<Map<String, Object>> allDate = AllDiffer.dif(dateOne, dateTwo);

        return Formatter.formatter(allDate, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getType(String filePath) {
        return filePath.substring(filePath.indexOf(".") + 1);
    }
}
