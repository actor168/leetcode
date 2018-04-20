public class Main003 {
    
    public static void main(String[] args){
        System.out.println(new Main003().lengthOfLongestSubstring("audaudf"));
    }
    
    

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        
        int start = 0;
        
        if (s.length() <= 0){
            return 0;
        }
        
        int maxLen = 1;
        int i = 0;
        for (i = 0; i < s.length(); i++){
            int ch = (int) s.charAt(i);
            if (chars[ch] != 0){
                if (i - start > maxLen){
                    maxLen = i - start;
                }
                start = start+1;
                i = start;
                chars = new int[256];
                chars[s.charAt(start)] = 1;
            }else {
                chars[ch] = 1;    
            }
        }
        
        if (i - start > maxLen){
            maxLen = i - start;
        }
        return maxLen;
    }
}
