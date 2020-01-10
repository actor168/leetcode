class Problem84 {
    public static void main(String[] args) {
        Problem84 p = new Problem84();
        int[] nums1= {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        p.merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1;
        int i = m-1;
        int j = n-1;
        while (pos >= 0 && i >=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[pos--] = nums1[i--];
            } else {
                nums1[pos--] = nums2[j--];
            };
        }

        while (i>=0) {
            nums1[pos--] = nums1[i--];
        }

        while (j>=0) {
            nums1[pos--] = nums2[j--];
        }
    }
}