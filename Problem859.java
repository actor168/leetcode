class Problem859 {
	public static void main(String[] args) {

		String A = "ab";
		String B = "ba";

		System.out.println(new Problem859().buddyStrings(A, B));
	}

	public boolean buddyStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        if (a.length != b.length) return false;

        char[] tmp = new char[26];

        int i = 0;
        boolean f = false;
        boolean ex = false;
        char pre = '\0';
        while (i < a.length) {
        	if (a[i] != b[i]) {
        		// 需要进行转换，然后再对比剩余，如果仍然存在不通，返回false，如果全部相同，返回true
        		if (f) return false; // 已经存在转换
        		int j = i;
        		while(j < a.length && a[j] != b[i]) {
        			j++;
        		}

        		if (j == a.length) {// 不存在
        			return false;
        		}

        		// 存在，进行转换
        		char c = a[i];
        		a[i] = a[j]; // a[i] = b[i];
        		a[j] = c;
        		f = true;
        	}
        	int k = a[i]-'a';
        	tmp[k]++;
        	if (tmp[k] > 1) ex = true;
        	i++;
        }
        // false 完全相同 但内含相同元素，可以作为相互交换条件
        if (!f && ex) return true; 
        return f;
    }
}