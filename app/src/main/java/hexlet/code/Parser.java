package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static List<Map<String, Object>> pars(Path firstFile, Path lastFile) {
        ObjectMapper mapper = new ObjectMapper();

        File contentFirstFile = new File(String.valueOf(firstFile));
        File contentLastFile = new File(String.valueOf(lastFile));

        Map<String, Object> mapFromFirstFile = null;
        try {
            mapFromFirstFile = mapper.readValue(contentFirstFile, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> mapFromLastFile = null;
        try {
            mapFromLastFile = mapper.readValue(contentLastFile, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> sortFirstFile = new TreeMap<>(mapFromFirstFile);
        Map<String, Object> sortLastFile = new TreeMap<>(mapFromLastFile);

        var parserMaps = new ArrayList<Map<String, Object>>();
        parserMaps.add(sortFirstFile);
        parserMaps.add(sortLastFile);
        return parserMaps;
    }
}
