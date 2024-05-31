import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TorreHanoiTest {

    @Test
    public void testMoveTorre() {
        String expectedOutput = "Movimento: A -> C\n" +
                                "Movimento: A -> B\n" +
                                "Movimento: C -> B\n" +
                                "Movimento: A -> C\n" +
                                "Movimento: B -> A\n" +
                                "Movimento: B -> C\n" +
                                "Movimento: A -> C\n";

        StringBuilder output = new StringBuilder();
        TorreDeHanoi.moveTorre(3, 'A', 'C', 'B', (De, Para) -> {
            output.append("Movimento: " + De + " -> " + Para + "\n");
        });

        assertEquals(expectedOutput, output.toString());
    }
}