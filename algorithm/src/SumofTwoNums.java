import org.jetbrains.annotations.NotNull;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SumofTwoNums {
	    public int[] twoSum(int @NotNull [] nums, int target) {
		        for(int i = 0; i < nums.length; i++) {
		            for(int j = i + 1; j < nums.length; j++) {
		                if(nums[i] + nums[j] == target) {
							return new int[]{i, j};
		                }
		            }
		        }
				throw new IllegalArgumentException("No illegal solution");

    }
}
