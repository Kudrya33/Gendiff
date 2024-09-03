package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    String file1 = "src/test/resources/fixtures/file1.json";
    String file2 = "src/test/resources/fixtures/file2.json";
    String file3 = "src/test/resources/fixtures/file1.yml";
    String file4 = "src/test/resources/fixtures/file2.yml";

    @Test
    public void testStylishJson() throws Exception {
        String format = "stylish";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedStylish.json");
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainJson() throws Exception {
        String format = "plain";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedPlain.json");
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonJson() throws Exception {
        String format = "json";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedJson.json");
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testStylishYml() throws Exception {
        String format = "stylish";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedYmlStylish.yml");
        var actual = Differ.generate(file3, file4, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainYml() throws Exception {
        String format = "plain";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedYmlPlain.yml");
        var actual = Differ.generate(file3, file4, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonYml() throws Exception {
        String format = "json";
        String expected = readExpectedFile("src/test/resources/fixtures/Expected/ExpectedYmlJson.yml");
        var actual = Differ.generate(file3, file4, format);
        assertEquals(expected, actual);
    }

    public static String readExpectedFile(String pathFile) throws Exception{
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

}
