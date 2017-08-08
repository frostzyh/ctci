package Ch02;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * This class generates random numbers from [a,b).
 * @author frostzyh
 */
public class RandomNumGenerator {
    int [] randomizedArray;

    /**
     * Generate a array of integer numbers from start (inclusive) to end
     * (exclusive) with size equals to (end - start).
     * @param start
     * @param end
     */
    public RandomNumGenerator(int start, int end) {
        if (end < start) throw new IllegalArgumentException("Invalid input. End should be larger than start.");
        int[] nums = new int[end - start];
        for (int i = 0, head = start; i < end - start; i++, head++) {
            nums[i] = head;
        }
        Random rdm = ThreadLocalRandom.current();

        for (int i = nums.length -1 ; i > 0; i--){
            int randomIndex = rdm.nextInt(i + 1);

            int temp = nums[i];
            nums[i] = nums[randomIndex];
            nums[randomIndex] = temp;
        }
        randomizedArray = nums;
    }

    /**
     *
     * @return
     */
    public int[] getArray() {
        return randomizedArray;
    }
}
