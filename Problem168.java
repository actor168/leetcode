class Problem168 {

	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(701));
		System.out.println(convertToTitle(1023));
		System.out.println(convertToTitle(7772));
		System.out.println(convertToTitle(52));

		Object o = null;
		long value = (long) o;
		System.out.println(value);

		// 703 AAA   703/26 = 27/26 = 1 ... 1
		// 702 ZZ   702/26 = 27/26 = 1   
		// 701 ZY   701/26 = 26/26 = 0 

		// 26  0Z 
		// 27  AA
		// 28  AB
		// 701 ZY
		// 702 ZZ

	}


	public static String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
        	res = (char)('A' + --n % 26) + res;
        	n = n / 26;
        }
        return res;
    }

}