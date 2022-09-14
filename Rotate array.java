Given an array, rotate the array to the right by k steps, where k is non-negative.

  
  Solution: three steps : 

reverse whole array 
reverse till k 
reverse from k to end ;

  
  code: 


class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
        }
    public void reverse(int nums[],int low,int high){
        while(low<high){
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}
