package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FormatJson {
    public static String json(Map<String, List<Object>> allDate) {

        Map<String, List<Object>> sortAllDate = new TreeMap<>(allDate);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(sortAllDate);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
