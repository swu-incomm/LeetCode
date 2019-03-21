package binarysearch;

public class ProblemA {
    public boolean binarySearch(int [] arr, int target) {
        int l = 0, r = arr.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) l = mid +1;
            else r = mid-1;
        }
        return false;
    }
    
    public static void main(String [] args) {
        ProblemA problemA = new ProblemA();
        int [] A = {
                10, 23, 36, 47, 59, 64, 71, 82, 95, 100, 116, 127, 138, 141, 152, 163
        };
        System.out.println(problemA.binarySearch(A, 36));
    }
}
