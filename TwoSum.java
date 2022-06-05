/*

1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

 */
import java.util.*;

class TwoSum{

    /*
    Store target-input[i] in hashmap<kay, index>.
    If input[i] is present in hashmap, that means we already have seen target-input[i]
     */
    public static int[] twoSum(int[]input, int target){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < input.length; i++){
        //Check in hashmap if input[i] is already added
        if(mp.getOrDefault(input[i], -1) != -1) {
        return new int[]{mp.get(input[i]), i};
        }else{
        mp.put(target-input[i], i);
        }
        }
        return new int[]{-1, -1};
        }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        int[] input = new int[n];
        while(i<n){
        input[i++] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] ans = twoSum(input, target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
