import java.util.*;

class Problem30 {
	public static void main(String[] args) {
		String[] words = new String[]{"foo", "bar"};
		String s = "barfoothefoobarman";

		System.out.print(new Problem30().findSubstring(s, words));
		
	}

	public List<Integer> findSubstring(String s, String[] words) {
        // 将words全排列，找到所有和新排列匹配的对象，时间复杂度为K！

        // request length of total words as substring, and compare with s.
		List<Integer> res = new ArrayList<>();
		// edge
       	if (s.length() <= 0 || words.length <= 0 || words[0].length() <= 0) {
       		return res;
       	}

       	// slide model
       	int size = words.length * words[0].length(); // minimal pattern length;
       	int len = words[0].length();
       	// 

       	HashMap<String, Integer> hashMap = new HashMap<>();
       	for (String word : words) {
       		if (hashMap.containsKey(word)) hashMap.put(word, hashMap.get(word) + 1);
       		else hashMap.put(word, 1);
       	}

       	int tmp = -1;
        for (int pos = 0; pos < s.length() - size + 1; pos++) {
        	String tStr = s.substring(pos, len+pos);
        	if (hashMap.containsKey(tStr)) {
        		int t = hashMap.get(tStr)-1;
        		hashMap.put(tStr, t);
        	} else if (checkMap(hashMap)) {
				pos--;
				res.add(pos+len-size);
				resetMap(hashMap);  
        	}
        }

        return res;
    }

    boolean checkMap(HashMap<String, Integer> hashMap) {
    	// check if all value is 0
    	boolean flag = true;
    	Iterator iter = hashMap.entrySet().iterator();
    	while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry) iter.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (val != 0) {
				flag = false;
				return flag;
			}
	    }
	    return flag;
	}

	void resetMap(HashMap<String, Integer> hashMap) {
		// reset all value to 1
		Iterator iter = hashMap.entrySet().iterator();
    	while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry) iter.next();
			String key = entry.getKey();
			hashMap.put(key, 1);
	    }
    }    
}