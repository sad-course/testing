import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.example.Triangle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TriangleTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void restoreSystemIO() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    @DisplayName("Test Main - Valid Triangle ")
    void testMainWithValidTriangle() {
        provideInput("3\n4\n5\n");

        Triangle.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("This is a triangle."));
    }

    @Test
    @DisplayName("Test Main - Invalid Triangle ")
    void testMainWithInvalidTriangle() {
        provideInput("1\n2\n3\n");

        Triangle.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("This is not a triangle."));
    }


    @Test
    @DisplayName("Test `isTriangle` - Each side shorter than the others ")
    void testIsTriangleMethodValid() {
        int a=2,b=2,c=3;
        assertTrue(Triangle.isTriangle(a,b,c));
    }

    @Test
    @DisplayName("Test `isTriangle` - One side equals 0 (Zero) ")
    void testIsTriangleMethodInvalidSideEqualZero() {
        int a=0,b=2,c=3;
        assertFalse(Triangle.isTriangle(a,b,c));
    }

    @Test
    @DisplayName("Test `isTriangle` - All sides equals 0 (Zero) ")
    void testIsTriangleMethodInvalidAllSidesEqualZero() {
        int a=0,b=0,c=0;
        assertFalse(Triangle.isTriangle(a,b,c));
    }

    @Test
    @DisplayName("Test `isTriangle` - One side equals the sum of the other ")
    void testIsTriangleMethodSideEqualsSumOfOther() {
        int a=1,b=2,c=3;
        assertFalse(Triangle.isTriangle(a,b,c));
    }


}
