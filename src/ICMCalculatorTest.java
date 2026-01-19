import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for ICMCalculator.
 *  
 *  @author fcalve4
 *  @version Aug 31, 2025
 * 
 */
public class ICMCalculatorTest
{
    
    @Test
    public void testCalculator() {
        int[] stacks = {500, 300, 200};
        double[] payouts = {70.0, 30.0};

        ICMCalculator calc = new ICMCalculator(stacks, payouts);
        double[] ev = calc.calculate();
        
        for (double e : ev) {
            System.out.println(e); 
        }
        

        assertEquals(45.17, ev[0], 1e-6);
        assertEquals(32.25, ev[1], 1e-6);
        assertEquals(22.57, ev[2], 1e-6);
    }

}
