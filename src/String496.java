import java.util.*;

public class String496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElement = allNextGreaterElement(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterElement.get(nums1[i]);
        }
        return result;
    }

    public static Map<Integer, Integer> allNextGreaterElement(int[] nums2) {
        Map nextGreaterElement = new HashMap<Integer, Integer>();
        int max = nums2[nums2.length-1];
        for (int i = nums2.length-1; i >= 0; i--) {
            if (nums2[i] >= max) {
                nextGreaterElement.put(nums2[i], -1);
                max = nums2[i];
            } else {
                nextGreaterElement.put(nums2[i], max);
            }
        }
        return nextGreaterElement;
    }
}
