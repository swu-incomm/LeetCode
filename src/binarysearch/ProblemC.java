package binarysearch;

public class ProblemC {
    public boolean shiftedArrySearch(int arr [], int target) {
        int l = 0, r = arr.length-1;
        while(l + 1 < r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] > arr[l]) {
                if(target > arr[l] && target < arr[mid]) r = mid;
                else l = mid;
            }else if(arr[mid] < arr[r]) {
                if(target > arr[mid] && target < arr[r]) l = mid;
                else r = mid;
            }
        }
        if(arr[l] == target) return true;
        if(arr[r] == target) return true;
        return false;
    }
    public static void main(String []args) {
        int [] test = {
                5,6,7,1,2,3,4
        };
        ProblemC problemC = new ProblemC();
        System.out.println(problemC.shiftedArrySearch(test, 2));
    }
}
