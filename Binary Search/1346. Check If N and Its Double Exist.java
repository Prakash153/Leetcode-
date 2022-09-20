Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for(int i: arr){
            if(i==0)
                count++;
            set.add(i);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                if(set.contains(arr[i]/2)){
                    if(arr[i]/2==0 && count>=2)
                        return true;
                    if(arr[i]/2!=0)
                        return true;
                }
            }
        }
        return false;
    }
}
