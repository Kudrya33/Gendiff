package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FormatPlain {
    public static String plain(Map<String, List<String>> allDate, Map<String,
            Object> dateOne, Map<String, Object> dateTwo) {

        Map<String, List<String>> sortAllDate = new TreeMap<>(allDate);

        var stringBuild = new StringBuilder("{\n");

        sortAllDate.forEach((key, value) -> {
            if (sortAllDate.get(key).size() > 1) {
                if (value.get(0) instanceof String) {

                }
                stringBuild.append("Property " + "'" + key + "' " + "was updated. From " + value.get(0) + " to " + value.get(1) + "\n");
            }
            if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && !dateTwo.containsKey(key)) {
                stringBuild.append("Property " + "'" + key + "' " + "was removed\n");
            }
            /*if (sortAllDate.get(key).size() < 2 && dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("    " + key + ": " + value.get(0) + "\n");
            }*/
            if (sortAllDate.get(key).size() < 2 && !dateOne.containsKey(key) && dateTwo.containsKey(key)) {
                stringBuild.append("Property " + "'" + key + "' " + "was added with value: " + value.get(0) + "\n");
            }
        });
        stringBuild.append("}");
        return stringBuild.toString();
    }
}
