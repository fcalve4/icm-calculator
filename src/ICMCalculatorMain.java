// -------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;

/**
 *  Main function for ICMCalculator
 * 
 *  @author fcalve4
 *  @version Aug 30, 2025
 */
public class ICMCalculatorMain
{


    /**
     * Main function - ICMCalculatorMain.java <input.txt>
     * @param args
     */
    public static void main(String[] args) {  
        if (args.length != 1) {
            System.out.println("Invalid arguments. Try again.");
            System.out.println(Arrays.toString(args));
            return;
        }
        
        File file = null; 
        try {
            file = new File(args[0]);
            
            Scanner sc = new Scanner(file);
            
            // first array
            String[] stackTokens = sc.nextLine().trim().split("[,\\s]+"); // regex delimiter
            int[] stacks = new int[stackTokens.length];
            for (int i = 0; i < stackTokens.length; i++) {
                stacks[i] = Integer.parseInt(stackTokens[i]);
            }

            // second array
            String[] payoutTokens = sc.nextLine().trim().split("[,\\s]+");
            double[] payouts = new double[payoutTokens.length];
            for (int i = 0; i < payoutTokens.length; i++) {
                payouts[i] = Double.parseDouble(payoutTokens[i]);
            }
            
            sc.close();
         
            ICMCalculator calculator = new ICMCalculator(stacks, payouts);
            double[] equities = calculator.calculate();
            
            
            System.out.println(Arrays.toString(equities));
           
        }
        catch (FileNotFoundException e) {
            System.out.println("Invalid file.");
            e.printStackTrace();
        }

    }
}
