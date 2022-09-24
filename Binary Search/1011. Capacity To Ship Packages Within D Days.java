A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on 
the conveyor belt (in the order given by weights). We may not load more weight
than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on 
the conveyor belt being shipped within days days.
  
  
  Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
  
  
  
  
  
  Solution : question states that we have to return the minimum capacity of the ship that can be shipped within 
d days. 
    
    , we can use binary search for finding the best possible answer. 
      
      how ? 
      ans : so in a single day maximum we can ship is the totsum of the weights. and minimum we can ship is the maximum wieght 
to be shipped. so our answer lies between totSum and max weight. 
        
        we can use binary search here and if the mid weight satisfies the condition of shipping the packages within <= days then
we try to find more better option by ignoring the right half, else we find in the right half. 
  
  
  
  code: 


class Solution {
    public boolean capacity(int arr[],int mid , int days){
        int d = 1 ; 
        int sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(sum+arr[i] <= mid) sum+= arr[i];
            else{
                sum = arr[i]; 
                d++;
            }
            
        }
        if(d <= days)
            return true;
        return false;
    }
    public int shipWithinDays(int[] arr, int days) {
        int max = 0 ; 
        int totSum = 0 ; 
        for(int i = 0 ; i <arr.length ; i++){
            if(max <  arr[i]) max = arr[i]; 
            totSum += arr[i];
        }
        int low = max ; 
        int high = totSum ; 
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2 ; 
            if(capacity(arr,mid,days))
            {
                ans = mid ; 
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
      
      
      
