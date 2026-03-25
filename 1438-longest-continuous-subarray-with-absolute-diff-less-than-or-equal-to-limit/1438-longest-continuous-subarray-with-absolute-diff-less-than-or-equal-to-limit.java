import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>(); // decreasing
        Deque<Integer> minDeque = new LinkedList<>(); // increasing
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // Maintain decreasing maxDeque
            while (!maxDeque.isEmpty() && num > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(num);

            // Maintain increasing minDeque
            while (!minDeque.isEmpty() && num < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(num);

            // Shrink window if condition violated
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}