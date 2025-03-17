package min_time_to_repair_cars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long min = 0;
        long max = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;


        while (min <= max) {
            long mid = (min + max) / 2;
            long carsRepairedForThatTime = getCarsRepairedForThatTime(mid, ranks);
            if (carsRepairedForThatTime >= cars) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private long getCarsRepairedForThatTime(long time, int[] ranks) {
        long cars = 0;

        for (int rank: ranks) {
            cars += (long) Math.sqrt((double) time / rank);
        }

        return cars;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repairCars(new int[] {4,2,3,1}, 10)); // should be 16
    }
}