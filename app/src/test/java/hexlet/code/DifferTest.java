package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testDiffer() throws Exception {
        String filepath1 = "/home/pavel/java-project-71/app/src/test/resources/file1.json";
        String filepath2 = "/home/pavel/java-project-71/app/src/test/resources/file2.json";
        String format = "stylish";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        var actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(expected, actual);
    }
}
