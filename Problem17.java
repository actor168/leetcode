import java.util.*;

class Problem17 {
	public static void main(String[] args) {
		System.out.println(new Problem17().letterCombinations("9"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() ==0) return res;

        char c = digits.charAt(0);
        char[] arr = null;
        char pos = (char)('a' + 3 * (c-'2'));
        if(c == '7' ) {
			arr = new char[]{(char)pos, (char)(pos+1), (char)(pos+2), (char)(pos+3)};
        }else
        if(c == '8') {
        	arr = new char[]{(char)(pos+1), (char)(pos+2), (char)(pos+3)};
        } else 
        if(c == '9') {
            arr = new char[]{(char)(pos+1), (char)(pos+2), (char)(pos+3),(char)(pos+4)};
        } else arr =  new char[]{(char)pos, (char)(pos+1), (char)(pos+2)};

		List<String> resSub = letterCombinations(digits.substring(1));
        for (int i = 0; i < arr.length; i++) {
        	if(resSub.size() > 0) {
        		for (int j = 0; j < resSub.size(); j++) {
        			res.add(String.valueOf(arr[i]) + resSub.get(j));
        		}
        	} else {
        		res.add(String.valueOf(arr[i]));
        	}
        }
        return res;
    }
}