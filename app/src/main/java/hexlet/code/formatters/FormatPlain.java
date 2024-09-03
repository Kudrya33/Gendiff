package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FormatPlain {
    public static String plain(List<Map<String, Object>> allDate) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> diffs : allDate) {
            switch (diffs.get("status").toString()) {
                case "removed" -> result.append("Property ")
                        .append("'")
                        .append(diffs.get("key"))
                        .append("'")
                        .append(" was removed")
                        .append("\n");
                case "added" -> result.append("Property ")
                        .append(complexValue(diffs.get("key")))
                        .append(" was added with value: ")
                        .append(complexValue(diffs.get("newValue")))
                        .append("\n");
                case "updated" -> result.append("Property ")
                        .append(complexValue(diffs.get("key")))
                        .append(" was updated. From ")
                        .append(complexValue(diffs.get("oldValue")))
                        .append(" to ")
                        .append(complexValue(diffs.get("newValue")))
                        .append("\n");
                default -> result.append("");
            }
        }
        return result.toString().trim();
    }

    public static String complexValue(Object data) {
        if (data instanceof Object[] || data instanceof Collections || data instanceof Map
                || data instanceof ArrayList<?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else if (data == null) {
            return null;
        }
        return data.toString();
    }

}
