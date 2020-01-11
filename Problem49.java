import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Problem49 {
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
        new Problem49().groupAnagrams(ttt);
    }
}