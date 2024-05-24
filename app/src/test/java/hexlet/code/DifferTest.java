package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    String file1 = "file1.json";
    String file2 = "file2.json";
    String file3 = "file1.yml";
    String file4 = "file2.yml";

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
        var actual = Parser.pars(file1, file2, format);
        assertEquals(expected, actual);
    }
    @Test
    public void testParser() throws Exception {
        String format = "stylish";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        var actual = Parser.pars(file3, file4, format);
        assertEquals(expected, actual);
    }
}
