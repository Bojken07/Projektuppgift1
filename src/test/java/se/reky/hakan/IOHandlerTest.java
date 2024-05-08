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
        ioHandler("test");
        Assertions.assertEquals("test", ioHandler("test").nextLine());
    }
    @Test
    public void testHasNextInt () {
        ioHandler("1");
        boolean hasInt = ioHandler("2").hasNextInt();
        Assertions.assertTrue(hasInt);
    }
}