package ex1;

public class PairsBelowThreshold {
    public static void main(String[] args) {
        System.out.println(countPairs(4, 5, new int[]{1, 2, 3, 4}));
        System.out.println(countPairs(4, 2, new int[]{1, 2, 3, -1}));
        System.out.println(countPairs(4, 4, new int[]{1, 2, 3, -1, 5}));
    }

    public static int countPairs(int n, int T, int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        if (!isSorted(A)) {
            A = mergeSort(A, 0, A.length - 1);
        }

        int count = 0;
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            if (A[left] + A[right] <= T) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    private static boolean isSorted(int[] A) {
        boolean sorted = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static int[] mergeSort(int[] A, int left, int right) {
        if (left >= right) {
            return new int[]{A[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftA = mergeSort(A, left, mid);
        int[] rightA = mergeSort(A, mid + 1, right);
        return merge(leftA, rightA);
    }

    public static int[] merge(int[] A, int[] B) {
        int[] mergedA = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        int k = 0;

        while (a < A.length && b < B.length) {
            if (A[a] <= B[b]) {
                mergedA[k++] = A[a];
                a++;
            } else {
                mergedA[k++] = B[b];
                b++;
            }
        }

        while (a < A.length) {
            mergedA[k++] = A[a];
            a++;
        }

        while (b < B.length) {
            mergedA[k++] = B[b];
            b++;
        }

        return mergedA;
    }
}