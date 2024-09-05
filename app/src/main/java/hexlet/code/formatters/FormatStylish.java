package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class FormatStylish {
    public static String stylish(List<Map<String, Object>> allDate) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diffs: allDate) {
            switch (diffs.get("type").toString()) {
                case "deleted" -> result.append("  - ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("value"))
                        .append("\n");
                case "added" -> result.append("  + ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("value"))
                        .append("\n");
                case "unchanged" -> result.append("    ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("value"))
                        .append("\n");
                default -> {
                    result.append("  - ")
                            .append(diffs.get("key"))
                            .append(": ")
                            .append(diffs.get("value1"))
                            .append("\n");
                    result.append("  + ")
                            .append(diffs.get("key"))
                            .append(": ")
                            .append(diffs.get("value2"))
                            .append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
