package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.FormatJson;
import hexlet.code.formatters.FormatPlain;
import hexlet.code.formatters.FormatStylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(List<Map<String, Object>> allDate, String format) throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> FormatStylish.stylish(allDate);
            case "plain" -> FormatPlain.plain(allDate);
            case "json" -> FormatJson.json(allDate);
            default -> throw new Error("Unknown format!");
        };
    }

}
