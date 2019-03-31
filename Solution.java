import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            List<String> list = null;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str); 
            map.put(key, list);  
        }
        List<List<String>> listRes = new ArrayList<>();
        for (List<String> l : map.values()) {
            listRes.add(l);
            System.out.println(l);
        }
        return listRes;
    }

    public static void main(String[] args) {
        String[] ttt = new String[]{"eat","tea","tan","ate","nat","bat"};
        new Solution().groupAnagrams(ttt);
    }
}