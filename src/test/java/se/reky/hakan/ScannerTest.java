package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class ScannerTest {

    Scanner scanner;

    @Test
    public void ScannerTest () {
        // Skapar en Scanner som använder en sträng "test" som inmatning.
        scanner = new Scanner("test");
        // Kontrollerar om nästa rad är tillgänglig för läsning.
        Assertions.assertTrue(scanner.hasNextLine());
        // Kontrollerar om nästa rad som läses är "test"
        Assertions.assertEquals("test", scanner.nextLine());
    }
}