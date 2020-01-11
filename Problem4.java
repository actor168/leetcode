class Problem4 {
	public static void main(String[] args) {
		int[] nums1 = {1,3,5};
		int[] nums2 = {2,8,17};
		System.out.println(new Problem4().findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// find the mid pos.

		if(nums1.length > nums2.length) {
			int[] tmp = nums2;
			nums2 = nums1;
			nums1 = tmp;
		} // swap length;

		int m = nums1.length;
		int n = nums2.length;

		int imin = 0;
		int imax = m;
		int ihalf = (m + n + 1) / 2;

		double m1=0.0, n2 = 0.0;

		while(imin <= imax) {
			// loop
			int i = (imax + imin) / 2; 
			int j = ihalf - i;

			if(i < m && nums1[i] < nums2[j-1]) {
				imin = i+1;
			} else if(i > 0 && nums1[i-1] > nums2[j]) {
				imax = i-1;
			} else{
				if(i == 0) {
					m1 = nums2[j-1];
				} else if (j == 0) {
					m1 = nums1[i-1];
				} else {
					m1 = Math.max(nums1[i-1],nums2[j-1]);
				}

			
            	if ((m + n) % 2 == 1) {
            		return m1;
            	}

				if (i == m) {
					n2 = nums2[j];
				} else if (j == n) {
					n2 = nums1[i];
				} else {
					n2 = Math.min(nums1[i], nums2[j]);
				}

				return (m1+n2)/2.0;

			}
		}
		return 0.0;
    }
}