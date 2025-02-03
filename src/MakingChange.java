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
    //do smallest number, then second smallest number + smallest but only one of them
    //then do target minus 2nd smallest number and repeat till can't anyone
    //move on to next biggest number
    public static long countWays(int target, int[] coins) {
       int ways = 0;
       int[] coin = new int[coins.length];
       // make a recursive code that counts the cobination possible to create a number
        for ()
        return ways;
    }

    public static int steps (int target, int[] coins, int numCoins, int biggestNum){
        int steps = 0;
        for (int i = 0; i < numCoins; i++){
            target = target - coins[biggestNum- i];
        }
        if (target % coins[0] == 0){
            steps = 1;
        }
        return steps;
    }

}
