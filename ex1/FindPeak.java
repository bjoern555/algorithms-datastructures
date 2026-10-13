package ex1;

public class FindPeak {
    public static void main(String[] args) {
        System.out.println(findPeak(0, new int[]{}));
        System.out.println(findPeak(1, new int[]{1}));
        System.out.println(findPeak(2, new int[]{1,2}));
        System.out.println(findPeak(4, new int[]{1,2,3,1}));
        System.out.println(findPeak(5, new int[]{1,5,3,2,1}));
        System.out.println(findPeak(5, new int[]{1,3,5,3,1}));
        System.out.println(findPeak(5, new int[]{1,2,3,4,1}));
        System.out.println(findPeak(5, new int[]{1,2,3,4,5,4,3,1}));
        System.out.println(findPeak(3, new int[]{3,2,1}));
        System.out.println(findPeak(2, new int[]{2,1}));
        System.out.println(findPeak(4, new int[]{4,3,2,1}));
    }

    public static int findPeak(int n, int[] arr) {
    if (n < 2) {
        return 0;
    }

    int l = 0;
    int r = n-1;

    while(l<r) {
        int mid = l + (r-l)/2;

        if (arr[mid] < arr[mid+1]) {
            l = mid+1;
        } else {
            r = mid;
        }
    }
    return l;
  }
}