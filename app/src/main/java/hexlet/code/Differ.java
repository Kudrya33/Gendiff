package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(Map<String, Object> sortFirstFile, Map<String, Object> sortLastFile) {
        var stringBuild = new StringBuilder("{\n");

        sortFirstFile.forEach((key, value) -> {
            if (!sortLastFile.containsKey(key)) {
                stringBuild.append(" - " + key + ": " + value + "\n");
            }
            if (sortLastFile.containsKey(key) && sortLastFile.containsValue(value)) {
                stringBuild.append("   " + key + ": " + value + "\n");
            }
            if (sortLastFile.containsKey(key) && !sortLastFile.containsValue(value)) {
                stringBuild.append(" - " + key + ": " + value + "\n");
                stringBuild.append(" + " + key + ": " + sortLastFile.get(key) + "\n");
            }
        });

        sortLastFile.forEach((key, value) -> {
            if (!sortFirstFile.containsKey(key)) {
                stringBuild.append(" + " + key + ": " + sortLastFile.get(key) + "\n");
            }
        });
        stringBuild.append("}");
        String result = stringBuild.toString();
        return result;
    }
}
