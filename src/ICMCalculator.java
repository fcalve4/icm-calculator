import java.util.HashMap;
import java.util.Map;

// -------------------------------------------------------------------------
/**
 * ICM Calculator. Computes each player's expected equity share of a tournament
 * prize pool using the Independent Chip Model (ICM)
 * 
 * @author fcalve4
 * @version Sep 1, 2025
 */
public class ICMCalculator
{
    private int[] stacks; // expressed as # of chips integer
    private double[] payouts; // expressed as a $ integer
    int numStacks;
    int numPayouts;

    // ----------------------------------------------------------
    /**
     * Create a new ICMCalculator object.
     * @param stacks List of player chip stacks
     * @param payouts List of payouts
     */
    public ICMCalculator(int[] stacks, double[] payouts)
    {
        this.stacks = stacks;
        this.payouts = payouts;
        
        this.numStacks = stacks.length;
        this.numPayouts = payouts.length;   
        
        
    }
    
    /**
     * Recursive get equity method
     * @param total Total chips in play
     * @param stack Player's chip stack 
     * @param playerIndex Index of player in stacks array
     * @param depth Current payout "depth"
     * @return The ICM equity for player
     *
     */
    public double getEquity(int total, int stack, int playerIndex, int depth) {
        double equity = ((double)stack / total) * this.payouts[depth];
        
        if (depth + 1 < this.numPayouts) {
            for (int i=0; i < this.numStacks; i++) {
                if (i != playerIndex) {
                    int currentStack = stacks[i];
                    this.stacks[i] = 0; // act as if this player busted
                    equity += ((double)currentStack / total) * getEquity((total - currentStack), stack, playerIndex, (depth + 1));
                    this.stacks[i] = currentStack; // Add "busted" player stack back in
                }
            }
        }
        
        return equity;
    }
    
    
     /**
     * Main calculator function
     * @return Double array of equities of players in stack order
     */
    public double[] calculate()
    {
        int totalChips = 0;   
        for (int stack : this.stacks) {
            totalChips += stack;
        }
       
        double[] finalEquities = new double[this.numStacks];
        
        for (int i=0; i < this.numStacks; i++) {
            int depth = 0;
            finalEquities[i] = getEquity(totalChips, this.stacks[i], i, depth);
        }
        
        return finalEquities;
    }



}
