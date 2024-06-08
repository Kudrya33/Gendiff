package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FormatStylish {
    public static String stylish(Map<String, List<Object>> allDate, Map<String,
            Object> dateOne, Map<String, Object> dateTwo) {

        Map<String, List<Object>> sortAllDate = new TreeMap<>(allDate);

        var stringBuild = new StringBuilder("{\n");

        sortAllDate.forEach((key, value) -> {
            if (sortAllDate.get(key).size() > 1) {
                stringBuild.append("  - " + key + ": " + value.get(0).toString() + "\n");
                stringBuild.append("  + " + key + ": " + value.get(1).toString() + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && !dateTwo.containsKey(key)) {
                stringBuild.append("  - " + key + ": " + value.get(0).toString() + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("    " + key + ": " + value.get(0).toString() + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && !dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("  + " + key + ": " + value.get(0).toString() + "\n");
            }
        });
        stringBuild.append("}");
        return stringBuild.toString();
    }
}
