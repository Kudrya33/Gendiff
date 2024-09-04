package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class FormatStylish {
    public static String stylish(List<Map<String, Object>> allDate) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diffs: allDate) {
            switch (diffs.get("status").toString()) {
                case "removed" -> result.append("  - ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("oldValue"))
                        .append("\n");
                case "added" -> result.append("  + ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("newValue"))
                        .append("\n");
                case "unchanged" -> result.append("    ")
                        .append(diffs.get("key"))
                        .append(": ")
                        .append(diffs.get("oldValue"))
                        .append("\n");
                default -> {
                    result.append("  - ")
                            .append(diffs.get("key"))
                            .append(": ")
                            .append(diffs.get("oldValue"))
                            .append("\n");
                    result.append("  + ")
                            .append(diffs.get("key"))
                            .append(": ")
                            .append(diffs.get("newValue"))
                            .append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
