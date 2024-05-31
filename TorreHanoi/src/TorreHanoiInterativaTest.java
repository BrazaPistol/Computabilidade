import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TorreHanoiInterativaTest {

    @Test
    public void testMoveTorreIterativo() {
        String expectedOutput = "Movimento: A -> C\n" +
                                "Movimento: A -> B\n" +
                                "Movimento: C -> B\n" +
                                "Movimento: A -> C\n" +
                                "Movimento: B -> A\n" +
                                "Movimento: B -> C\n" +
                                "Movimento: A -> C\n";

        StringBuilder output = new StringBuilder();

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream printStream = new java.io.PrintStream(baos);
        java.io.PrintStream originalOut = System.out;
        System.setOut(printStream);

        TorreHanoiInterativa.moveTorreIterativo(3, 'A', 'C', 'B');

        System.setOut(originalOut);
        output.append(baos.toString());

        assertEquals(expectedOutput, output.toString());
    }
}