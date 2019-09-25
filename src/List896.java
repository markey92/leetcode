public class List896 {

    public static void main(String[] args) {
        int[] A = {6,3,4,4};
        System.out.println(isMonotonic(A));
    }
    public static boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        //判断升序还是降序
        boolean asc = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] < A[i]) {
                asc = true;
                if (i+1 < A.length && A[i] > A[i+1]) {
                    return false;
                }
            }
            if (A[i-1] > A[i]) {
                asc = false;
                if (i+1 < A.length && A[i] < A[i+1]) {
                    return false;
                }
            }
        }

        int i = 0;
        while (i < A.length-1) {
            if (asc && A[i] > A[i+1]) {
                return false;
            }
            if (!asc && A[i] < A[i+1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
