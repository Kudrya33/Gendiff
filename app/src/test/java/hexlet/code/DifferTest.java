package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    String filepath1 = "/home/pavel/java-project-71/app/file1.json";
    String filepath2 = "/home/pavel/java-project-71/app/file2.json";

    @Test
    public void testDiffer() throws Exception {
        String format = "stylish";
        Path first = Paths.get(filepath1).toAbsolutePath().normalize();
        Path last = Paths.get(filepath2).toAbsolutePath().normalize();
        String expected = "{\n" +
                " - follow: false\n" +
                "   host: hexlet.io\n" +
                " - proxy: 123.234.53.22\n" +
                " - timeout: 50\n" +
                " + timeout: 20\n" +
                " + verbose: true\n" +
                "}";
        var actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(expected, actual);
    }
}
