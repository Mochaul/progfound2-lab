import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This code is redeveloped from Ichlasul Affan's code.
 */
@DisplayName("RabbitHouse")
public class RabbitHouseTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;

    @BeforeEach
    void setUp() {
        // Make new ByteArrayOutputStream for output and error output
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
        System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
    }

    @Test
    @DisplayName("Direct Input Testcase: Input Example 1")
    void testInput1() {
        ByteArrayInputStream in = new ByteArrayInputStream("normal PEWEW\n".getBytes());
        System.setIn(in);

        Scanner keyboard = new Scanner(System.in);

        RabbitHouse.main(new String[0]);

        if (!outContent.toString().contains("206")) {
            fail("Testcase 1 failed");
        }
    }

    @Test
    @DisplayName("Direct Input Testcase: Input Example 2")
    void testInput2() {
        ByteArrayInputStream in = new ByteArrayInputStream("normal EXODUS\n".getBytes());
        System.setIn(in);

        Scanner keyboard = new Scanner(System.in);

        RabbitHouse.main(new String[0]);

        if (!outContent.toString().contains("1237")) {
            fail("Testcase 2 failed");
        }
    }

    @Test
    @DisplayName("Direct Input Testcase: Input Example 3")
    void testInput3() {
        ByteArrayInputStream in = new ByteArrayInputStream("normal J\n".getBytes());
        System.setIn(in);

        Scanner keyboard = new Scanner(System.in);

        RabbitHouse.main(new String[0]);

        if (!outContent.toString().contains("1")) {
            fail("Testcase 3 failed");
        }
    }

}
