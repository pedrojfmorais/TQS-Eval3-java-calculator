package calculator.tests;

import calculator.Calculator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorParseExpressionTest {

    private ParseExpressionModel executeAndCaptureOutput(String input) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        boolean result = Calculator.parseExpression(input);
        System.setOut(originalOut);
        return new ParseExpressionModel(outputStream.toString().replaceAll("\n", ""), result);
    }

    @Test
    public void testPrimePath1() {
        ParseExpressionModel result = executeAndCaptureOutput("defaultTrig 30");
        assertEquals("Invalid Input", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath2() {
        ParseExpressionModel result = executeAndCaptureOutput("2 + 2");
        assertEquals("4.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath3() {
        ParseExpressionModel result = executeAndCaptureOutput("tan 45");
        assertEquals("1.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath4() {
        ParseExpressionModel result = executeAndCaptureOutput("cos 60");
        assertEquals("0.50", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath5() {
        ParseExpressionModel result = executeAndCaptureOutput("sin 30");
        assertEquals("0.50", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath6() {
        ParseExpressionModel result = executeAndCaptureOutput("5 - 3");
        assertEquals("2.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath7() {
        ParseExpressionModel result = executeAndCaptureOutput("2 ^ 3");
        assertEquals("8.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath8() {
        ParseExpressionModel result = executeAndCaptureOutput("4 % 2");
        assertEquals("Invalid Input", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath9() {
        ParseExpressionModel result = executeAndCaptureOutput("6 / 2");
        assertEquals("3.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath10() {
        ParseExpressionModel result = executeAndCaptureOutput("3 * 4");
        assertEquals("12.00", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath11() {
        ParseExpressionModel result = executeAndCaptureOutput("singleWord");
        assertEquals("Invalid Input", result.print());
        assertTrue(result.output());
    }

    @Test
    public void testPrimePath12() {
        ParseExpressionModel result = executeAndCaptureOutput("quit");
        assertTrue(result.print().isBlank());
        assertFalse(result.output());
    }

    @Test
    public void testPrimePath13() {
        ParseExpressionModel result = executeAndCaptureOutput("cos text");
        assertEquals("Invalid Input", result.print());
        assertTrue(result.output());
    }
}

