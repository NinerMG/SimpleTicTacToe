

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void testStringInput1(){
        String input = "O_OXXO_XX";
        String expectedResult =
                        "---------\n" +
                        "| O _ O |\n" +
                        "| X X O |\n" +
                        "| _ X X |\n" +
                        "---------\n";
        assertGridOutput(input, expectedResult);
    }
    @Test
    public void testStringInput2(){
        String input = "OXO__X_OX";
        String expectedResult =
                "---------\n" +
                        "| O X O |\n" +
                        "| _ _ X |\n" +
                        "| _ O X |\n" +
                        "---------\n";
        assertGridOutput(input, expectedResult);
    }
    @Test
    public void testStringInput3(){
        String input = "_XO__X___";
        String expectedResult =
                "---------\n" +
                        "| _ X O |\n" +
                        "| _ _ X |\n" +
                        "| _ _ _ |\n" +
                        "---------\n";
        assertGridOutput(input, expectedResult);
    }

    private void assertGridOutput(String input, String expectedOutput){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        new Grid(input);

        System.setOut(originalOut);

        String actualOutput = outputStream.toString();

        actualOutput = actualOutput.replace("\r\n", "\n").trim();
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
