/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int a;
        for(int i=0; i<nums.length; i++){
            a = target - nums[i];
           for(int j=i+1;j<nums.length;j++){
             if(a == nums[j]){
                 int[] arr = new int[2];
                 arr[0] = i;
                 arr[1] = j;
                 return arr;
             }
           }
        }
        return null;
        
    }
}