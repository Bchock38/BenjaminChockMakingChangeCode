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
    //do smallest number, then second smallest number + smallest but only one of them
    //then do target minus 2nd smallest number and repeat till can't anyone
    //move on to next biggest number
    static long[][] steps;
    public static long countWays(int target, int[] coins) {
      long ways = 0;
      steps = new long[coins.length][target+1];
        for (long[] step : steps) {
            Arrays.fill(step, -1);
        }
        Arrays.sort(coins);
        ways = countMemo(target,coins,0);
        return ways;
    }

    public static long countMemo (int target, int[] coins, int start) {
        long ways = 0;
        if (steps[start][target] != -1){
            return steps[start][target];
        }
        if (target == 0){
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


        steps[start][target] = ways;

        return ways;

    }


}
