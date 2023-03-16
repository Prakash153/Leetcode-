Given a list arr of N integers, print sums of all subsets in it.

 

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
Your Task:  
You don't need to read input or print anything. Your task is to complete the
  function subsetSums() which takes a list/vector and an integer N as an input parameter and return the list/vector of all the subset sums.

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)
  
  
  code: 
class Solution{
    void solve(ArrayList<Integer> arr , int i , int n , int sum ,ArrayList<Integer> ans ){
        if(i== n)
        {
            ans.add(sum);
            return ;
        }
        solve(arr, i + 1 , n , sum, ans);    // take
        solve(arr , i + 1 , n , sum + arr.get(i) , ans);  // not take
        
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans =new ArrayList<>(); 
 
        solve(arr,0,arr.size(),0 ,ans); 
        
        return ans;
        
    }
}
