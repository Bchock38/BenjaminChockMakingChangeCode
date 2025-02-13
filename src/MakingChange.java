import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Benjamin Chock
 */

public class MakingChange {
    /**
     */
    static long[][] steps;
    public static long countWays(int target, int[] coins) {
      long ways = 0;
      // Call Memoization solver
      // ways = callMemo(target,coins);
      // Call Tabulation solver
       ways = countTab(coins,target);
       // Return the number of coin solutions
       return ways;
    }

    // Function that sets up and call Memoization solver
    public static long callMemo(int target, int[] coins){
        long ways = 0;
        // Intialize array to hold number of steps for each used coin combo
        steps = new long[coins.length][target+1];
        // Fill array with -1 so I can check if it's empty or not while not getting it confused with actual 0s
        for (long[] step : steps) {
            Arrays.fill(step, -1);
        }
        // Sort coin array from greatest to least
        Arrays.sort(coins);
        // Run memoization solver
        ways = countMemo(target,coins,0);
        // Return all the coin combos you can use
        return  ways;
    }
    public static long countMemo (int target, int[] coins, int start) {
        long ways = 0;
        // If this coin combo has been used take the already known number of steps
        if (steps[start][target] != -1){
            return steps[start][target];
        }
        // If target is zero steps will be equal to 1
        if (target == 0){
            // Save the number of steps this took
            steps[start][target] = 1;
            return 1;
        }
        // Include
        if (target-coins[start] >= 0){
            ways = countMemo(target-coins[start],coins,start);
        }
        // Exclude
        if (start+1 < coins.length){
            ways += countMemo(target, coins, start+1);
        }
        // Take the steps from the orginal target and all the coins
        steps[start][target] = ways;
        // Return that value
        return ways;
    }

    public static long countTab (int[] coins, int target){
        // Make table for holding tabulation saved coin values
        long[][] tabVals = new long[coins.length][target+1];
        // Travese the whole 2d Array
        for (int i = 0; i < tabVals.length; i++){
            for (int j = 0; j < tabVals[i].length; j++){
                // If target is 0 steps will always be 1
                if (j == 0){
                    tabVals[i][j] = 1;
                }
                else {
                     // Add the value from the box above your current box if it's inbounds
                     if (i -1 >= 0){
                         tabVals[i][j] += tabVals[i-1][j];
                     }
                     // Add the value from the box the coin value to the left if it's in bounds
                     if (j - coins[i] >= 0){
                         tabVals[i][j] += tabVals[i][j- coins[i]];
                     }
                }
            }
        }
        // Return the steps from the box that lines up with orginal target and all the coin values
        return tabVals[coins.length-1][target];
    }

}
