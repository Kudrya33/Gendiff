package hexlet.code.formatters;

import java.util.*;

public class FormatPlain {
    public static String plain(Map<String, List<Object>> allDate, Map<String,
            Object> dateOne, Map<String, Object> dateTwo) {

        Map<String, List<Object>> sortAllDate = new TreeMap<>(allDate);

        var stringBuild = new StringBuilder();

        sortAllDate.forEach((key, value) -> {
            if (sortAllDate.get(key).size() > 1) {
                if (value.get(0) instanceof String && !value.get(0).equals("null")) {
                    value.set(0, "'" + value.get(0) + "'");
                }
                if (value.get(1) instanceof String && !value.get(1).equals("null")) {
                    value.set(1, "'" + value.get(1) + "'");
                }
                if (value.get(0) instanceof ArrayList<?> || value.get(0) instanceof Map) {
                    value.set(0, "[complex value]");
                }
                if (value.get(1) instanceof  ArrayList<?> || value.get(1) instanceof Map) {
                    value.set(1, "[complex value]");
                }
                stringBuild.append("Property " + "'" + key + "' " + "was updated. From "
                        + value.get(0).toString() + " to " + value.get(1).toString() + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && !dateTwo.containsKey(key)) {
                if (value.get(0) instanceof String && !value.get(0).equals("null")) {
                    value.set(0, "'" + value.get(0) + "'");
                }
                if (value.get(0) instanceof ArrayList<?> || value.get(0) instanceof Map) {
                    value.set(0, "[complex value]");
                }
                stringBuild.append("Property " + "'" + key + "' " + "was removed\n");
            }
            if (sortAllDate.get(key).size() < 2 && !dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                if (value.get(0) instanceof String && !value.get(0).equals("null")) {
                    value.set(0, "'" + value.get(0) + "'");
                }
                if (value.get(0) instanceof ArrayList<?> || value.get(0) instanceof Map) {
                    value.set(0, "[complex value]");
                }
                stringBuild.append("Property " + "'" + key + "' " + "was added with value: " + value.get(0).toString() + "\n");
            }
        });
        return stringBuild.toString().trim();
    }
}
