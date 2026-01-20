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
    private int numStacks;
    private int numPayouts;

    // ----------------------------------------------------------
    /**
     * Create a new ICMCalculator
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
     * Recursive function that calculates a player's ICM equity 
     * @param total Total chips in play
     * @param stack Player's chip stack 
     * @param playerIndex Index of player in stacks array
     * @param payoutIndex Current payout "payoutIndex"
     * @return The ICM equity for player
     *
     */
    public double getEquity(int total, int stack, int playerIndex, int payoutIndex) {
        double equity = ((double)stack / total) * this.payouts[payoutIndex];
        
        if (payoutIndex + 1 < this.numPayouts) {
            for (int i=0; i < this.numStacks; i++) {
                if (i != playerIndex) {
                    int currentStack = stacks[i];
                    this.stacks[i] = 0; // act as if this player busted
                    equity += ((double)currentStack / total) * getEquity((total - currentStack), stack, playerIndex, (payoutIndex + 1));
                    this.stacks[i] = currentStack; // Add "busted" player stack back in
                }
            }
        }
        
        return equity;
    }
    
    
     /**
     * Main calculator function that calls getEquity() on all players
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
            int payoutIndex = 0;
            finalEquities[i] = getEquity(totalChips, this.stacks[i], i, payoutIndex);
        }
        
        return finalEquities;
    }



}
