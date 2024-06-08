package hexlet.code;

import hexlet.code.formatters.FormatPlain;
import hexlet.code.formatters.FormatStylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(Map<String, List<Object>> allDate, Map<String,
            Object> dateOne, Map<String, Object> dateTwo, String format) {
        String result = "";

        switch (format) {
            case "stylish":
                result = FormatStylish.stylish(allDate, dateOne, dateTwo);
                break;
            case "plain":
                result = FormatPlain.plain(allDate, dateOne, dateTwo);
                break;
            default:
                result = FormatStylish.stylish(allDate, dateOne, dateTwo);
        }
        return result;
    }
}
