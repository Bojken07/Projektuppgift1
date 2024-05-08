package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class ScannerTest {

    Scanner scanner;

    @Test
    public void ScannerTest () {
        scanner = new Scanner("test");
        Assertions.assertTrue(scanner.hasNextLine());
        Assertions.assertEquals("test", scanner.nextLine());
    }
}