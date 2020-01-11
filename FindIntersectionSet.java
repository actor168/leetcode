import java.util.*;

class FindIntersectionSet {
    public int[] intersect(int[] nums1, int[] nums2) {
        //scan min(nums1, nums2) array and store the least one and its count size into hashmap 
        //if it exists, then count-- from the hashmap, and add the result into the result array
        //and continue on.
        List<Integer> res = new ArrayList<>();
        //step 1.
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        
        //step2.
        for (int i : nums2) {
            if (hashMap.containsKey(i) && hashMap.get(i) > 0) { //reduce the result
                hashMap.put(i, hashMap.get(i) - 1);
                res.add(i);
            }
        }

        int[] arr = new int[res.size()];

        for (int i =0 ; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}