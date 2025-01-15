import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    public OperationsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMakeFormula() {
        String formula = Operations.MakeFormula();
        assertNotNull(formula, "La fórmula generada no debe ser nula");
        assertFalse(formula.isEmpty(), "La fórmula generada no debe estar vacía");
        assertTrue(formula.matches("[0-9+\-*/]+"), "La fórmula debe contener solo números y operadores válidos");
    }

    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }


    @Test
    public void testSolveSimpleAddition() {
        String formula = "1+1";
        String result = Operations.Solve(formula);
        assertEquals("1+1=2", result, "El resultado de 1+1 debe ser 2");
    }

    @Test
    public void testSolveSimpleMultiplication() {
        String formula = "2*3";
        String result = Operations.Solve(formula);
        assertEquals("2*3=6", result, "El resultado de 2*3 debe ser 6");
    }

    @Test
    public void testSolveOperatorPrecedence() {
        String formula = "1+2*3";
        String result = Operations.Solve(formula);
        assertEquals("1+2*3=7", result, "El resultado de 1+2*3 debe respetar la precedencia de operadores y ser 7");
    }



}