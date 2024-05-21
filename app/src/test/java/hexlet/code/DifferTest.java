package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    String file1 = "/src/test/resources/file1.json";
    String file2 = "src/test/resources/file2.json";

    @Test
    public void testDiffer() throws Exception {
        String format = "stylish";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }
}
