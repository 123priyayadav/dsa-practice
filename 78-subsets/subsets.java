import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {

            temp.add(nums[i]);         

            helper(i + 1, nums, temp, ans); 

            temp.remove(temp.size() - 1);   
        }
    }
}