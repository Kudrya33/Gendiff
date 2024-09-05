package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parser {
    public static List<Map<String, Object>> pars(Path firstFile, Path lastFile, String type1, String type2) throws IOException {
        Map<String, Object> mapFromFirstFile = Map.of();
        Map<String, Object> mapFromLastFile = Map.of();

        if (type1.equals("json")) {
            mapFromFirstFile = jsonFormat(firstFile);
        }
        if (type2.equals("json")) {
            mapFromLastFile = jsonFormat(lastFile);
        }
        if (type1.equals("yaml")) {
            mapFromFirstFile = yamlFormat(firstFile);
        }
        if (type2.equals("yaml")) {
            mapFromLastFile = yamlFormat(lastFile);
        }

        var parserMaps = new ArrayList<Map<String, Object>>();
        parserMaps.add(mapFromFirstFile);
        parserMaps.add(mapFromLastFile);
        return parserMaps;
    }
    public static Map<String, Object> jsonFormat(Path path) throws IOException {
        ObjectMapper mapperJson = new ObjectMapper();
        File content = new File(String.valueOf(path));
        Map<String, Object> map = mapperJson.readValue(content, Map.class);
        return map;
    }
    public static Map<String, Object> yamlFormat(Path path) throws IOException {
        ObjectMapper mapperYaml = new YAMLMapper();
        File content = new File(String.valueOf(path));
        Map<String, Object> map = mapperYaml.readValue(content, Map.class);
        return map;
    }
}
