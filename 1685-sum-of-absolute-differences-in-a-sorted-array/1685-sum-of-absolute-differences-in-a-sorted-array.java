class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the total sum of the array first
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // totalSum - leftSum - nums[i] gives the sum of all elements to the right
            int rightSum = totalSum - leftSum - nums[i];
            
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            // Formula: (nums[i] * countBefore - sumBefore) + (sumAfter - nums[i] * countAfter)
            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (rightCount * nums[i]);
            
            result[i] = leftTotal + rightTotal;
            
            // Update leftSum for the next element
            leftSum += nums[i];
        }
        
        return result;
    }
}
