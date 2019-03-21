package binarysearch;

//We take 0 as natural number, too
public class ProblemD {
    public int smallestMissingNaturalNumber(int [] arr, int start, int end) {
        if(start > end) return end + 1;
        if(start != arr[start])
            return start;
        int mid = start + (end-start) / 2;
        if(arr[mid] == mid)
            return smallestMissingNaturalNumber(arr, mid+1, end);
        return smallestMissingNaturalNumber(arr, start, mid);
        
    }
}
