import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                if (i - lastIndex <= k) {
                    return true;
                }
            }
            // Update the last seen index
            map.put(nums[i], i);
        }

        return false;
    }
}