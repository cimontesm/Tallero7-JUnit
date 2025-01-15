import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorSMPTest {

    @Test
    public void testMainFlow() {
        
        String formula = Operations.MakeFormula();
        assertNotNull(formula, "La fórmula generada no debe ser nula");
        assertFalse(formula.isEmpty(), "La fórmula generada no debe estar vacía");

        String result = Operations.Solve(formula);
        assertNotNull(result, "El resultado de resolver la fórmula no debe ser nulo");

        
        assertTrue(result.contains("="), "El resultado debe contener un '=' para separar la fórmula y su solución");

        String[] parts = result.split("=");
        assertEquals(2, parts.length, "El resultado debe dividirse en fórmula y solución");

       
        try {
            Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            fail("La parte de la solución del resultado debe ser un número válido");
        }
    }
}
