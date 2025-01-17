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
    public void testFormulaLength() {
        String formula = Operations.MakeFormula();
        // La longitud de la fórmula debería ser siempre impar
        assertTrue(formula.length() % 2 != 0);
    }

    @Test
    public void testFormulaOperators() {
        String formula = Operations.MakeFormula();
        assertTrue(formula.contains("+") || formula.contains("-") || formula.contains("*"));
    }

    @Test
    public void testFormulaNumbers() {
        String formula = Operations.MakeFormula();
        String[] parts = formula.split("[+\\-\\*]");
        for (String part : parts) {
            int number = Integer.parseInt(part);
            assertTrue(number >= 1 && number <= 99);
        }
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
    @Test 
    public void testSolveParenthesesPrecedence() { 
        String formula = "2*(3+4)"; 
        String result = Operations.Solve(formula); 
        assertEquals("2*(3+4)=14", result, "El resultado de 2*(3+4) debe ser 14"); 
} 

    @Test
    public void testSolveInvalidInput() { 
       String formula = "abc"; 
       Exception exception = assertThrows(NumberFormatException.class, () -> { 
         Operations.Solve(formula); 
    }); 
        assertNotNull(exception, "Una entrada inválida debe lanzar una excepción"); 
}

     @Test 
    public void testSolveNegativeNumbers() { 
      String formula = "-1+2"; 
      String result = Operations.Solve(formula); 
      assertEquals("-1+2=1", result, "El resultado de -1+2 debe ser 1"); 
} 


}