package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Formatter {
    public static String format(Map<String, List<String>> allDate, Map<String, Object> dateOne, Map<String, Object> dateTwo) {

        Map<String, List<String>> sortAllDate = new TreeMap<>(allDate);

        var stringBuild = new StringBuilder("{\n");

        sortAllDate.forEach((key, value) -> {
            if (sortAllDate.get(key).size() > 1) {
                stringBuild.append("  - " + key + ": " + value.get(0) + "\n");
                stringBuild.append("  + " + key + ": " + value.get(1) + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && !dateTwo.containsKey(key)) {
                stringBuild.append("  - " + key + ": " + value.get(0) + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("    " + key + ": " + value.get(0) + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && !dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("  + " + key + ": " + value.get(0) + "\n");
            }
        });
        stringBuild.append("}");
        return stringBuild.toString();
    }
}
