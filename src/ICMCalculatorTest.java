import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

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
    public void test3stacks1payout() {
        int[] stacks = {500, 300, 200};
        double[] payouts = {100.0};

        ICMCalculator calc = new ICMCalculator(stacks, payouts);
        double[] ev = calc.calculate();

        System.out.println(Arrays.toString(ev));

        assertEquals(50, ev[0], 1e-2);
        assertEquals(30, ev[1], 1e-2);
        assertEquals(20, ev[2], 1e-2);
    }
    
    @Test
    public void test3stacks2payouts() {
        int[] stacks = {500, 300, 200};
        double[] payouts = {70.0, 30.0};

        ICMCalculator calc = new ICMCalculator(stacks, payouts);
        double[] ev = calc.calculate();

        System.out.println(Arrays.toString(ev));

        assertEquals(45.17, ev[0], 1e-2);
        assertEquals(32.25, ev[1], 1e-2);
        assertEquals(22.57, ev[2], 1e-2);
    }
    
    @Test
    public void test3stacks3payouts() {
        int[] stacks = {10000, 5000, 3000};
        double[] payouts = {100.0, 30.0, 20.0};

        ICMCalculator calc = new ICMCalculator(stacks, payouts);
        double[] ev = calc.calculate();

        System.out.println(Arrays.toString(ev));

        assertEquals(67.69, ev[0], 1e-2);
        assertEquals(46.25, ev[1], 1e-2);
        assertEquals(36.06, ev[2], 1e-2);
    }
    
    @Test
    public void testMain() {
        
    }

}
