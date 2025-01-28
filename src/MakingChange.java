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
    public static long countWays(int target, int[] coins) {
       int ways = 0;

       // make a recursive code that counts the cobination possible to create a number

        return ways;
    }

    public static int[] steps (int target, int[] coins){
        int[] mod = new int[coins.length];
        int[] steps = new int[coins.length];
        for (int i = 0; i < coins.length; i++){
            mod[i] = target%coins[i];
            steps[i] = target/coins[i];
        } 
        return steps;
    }

}
