package se.reky.hakan;

import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IOHandlerTest {

    private IOHandler ioHandler (String dataForScanner) {
        IOHandler ioHandler = new IOHandler(new Scanner(dataForScanner));
        return ioHandler;
    };
    @Test
    public void IoHandlerTest () {
        // Skapar en instans av IOHandler med en Scanner som innehåller sträng "test".
        ioHandler("test");
        // Kontrollerar att nästa inläsning från IOHandler returnerar "test".
        Assertions.assertEquals("test", ioHandler("test").nextLine());
    }
    @Test
    public void testHasNextInt () {
        // Skapar en instans av IOHandler med en scanner som innehåller sträng "1"
        ioHandler("1");
        // Kontrollerar om nästa token som läsas från IOHandler är en int.
        boolean hasInt = ioHandler("2").hasNextInt();
        // Verifierar att det finns en int att läsa.
        Assertions.assertTrue(hasInt);
    }
}