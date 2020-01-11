import java.util.ArrayList;
import java.util.List;

class LongestSubStr {
    public static void main(String[] args) {
        LongestSubStr s = new LongestSubStr();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring(""));
        System.out.println(s.lengthOfLongestSubstring("pwwwkewpwdweweadfasfsaf"));

    }

    
    public int lengthOfLongestSubstring(String s) {
        int max=0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();
            char start = s.charAt(i);
            list.add(start);
            for (j = i+1; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    break;
                }
                list.add(s.charAt(j));
            }
            int curSize = j - i;
            max = max > curSize ? max : curSize;
        }
        return max;        
    }

}