package KthElementofTowSortedArrays;
/*Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be 
at the k’th position of the final sorted array.

Examples:

Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
Output : 6
Explanation: The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Input : Array 1 - 100 112 256 349 770
        Array 2 - 72 86 113 119 265 445 892
        k = 7
Output : 256
Explanation: Final sorted array is -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.
*/
public class Solution {
    // Basic O(m+n)
    public int kthBasic(int[] arr1, int[] arr2, int m, int n, int k) {
        if (arr1 == null && arr2 == null)
            return 0;
        int i = 0, j = 0, count = 0;
        int[] sortedArray = new int[n + m];
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                sortedArray[count++] = arr1[i++];
            } else {
                sortedArray[count++] = arr2[j++];
            }
        }
        while (i < m) {
            sortedArray[count++] = arr1[i++];
        }
        while (j < n) {
            sortedArray[count++] = arr2[j++];
        }
        return sortedArray[k - 1];
    }
    // Divide & Conquer serach in arr1[p....q]
    public int kthRecursive(int[] arr1, int[] arr2, int m, int n, int k, int p, int q) {
        if (p > q)
        return kthRecursive(arr2,arr1,n, m, k, 0, n-1);//search in B
            
        int i = p + (q - p) / 2;
        int j = k - 1 - i - 1;
            
        if ((j < 0 || (j < n && arr1[i] >= arr2[j])) 
            && (j+1 >= n || (j+1 >= 0 && arr1[i] <= arr2[j+1]))) {
            return arr1[i];
        } else if (j < 0 || (j+1 < n && arr1[i] > arr2[j+1])) {
            return kthRecursive(arr1, arr2, m, n, k, p, i-1);
        } else {
            return kthRecursive(arr1, arr2, m, n, k, i+1, q);
        }   
    }
    public static void main(String[] args) {
        // Create Test Case
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int[] arr3 = { 100, 112, 256, 349, 770 };
        int[] arr4 = { 72, 86, 113, 119, 265, 445, 892 };
        Solution solution = new Solution();
        // Basic Approach
        System.out.println(solution.kthBasic(arr1, arr2, 5, 4, 5));
        System.out.println(solution.kthBasic(arr3, arr4, 5, 7, 7));
        //Recursive
        System.out.println(solution.kthRecursive(arr1, arr2, 5, 4, 5, 0, 4));
        System.out.println(solution.kthRecursive(arr3, arr4, 5, 7, 7, 0, 4));
    }
}
