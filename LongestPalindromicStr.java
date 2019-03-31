import java.util.ArrayList;
import java.util.List;

class LongestPalindromicStr {
    // 找出最长回文子串
    public String longestPalindrome_bak(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char[] charArr = s.toCharArray();
        int maxSize = 0;
        String resStr = "";

        for (int cur = 1; cur < charArr.length - maxSize / 2; cur++) {
            int left = cur, right = cur;
            int size = 0;
            boolean flag1 = false;
            boolean flag2 = false;
            
            while (!flag1 && !flag2 && charArr[left] == charArr[right]) {
                //多个重叠中间情况的处理
                if (cur == left) {
                    while(charArr[cur] == charArr[right]) {
                        right++;
                        if (right == charArr.length) {
                            break;
                        }
                    }
                }
                left--;
                if (right < charArr.length) {
                    right++;
                }
                
                if (left < 0) {
                    flag1 = true;
                }
                if (right >= charArr.length) {
                    flag2 = true;
                }
            }

            //判断退出时的状态
            //1. 左右不等，但未到左右边界
            if (flag1 == flag2 == false) {
                left++;
                //不需要right--，因为substring不包含右边界
            }
            //2. 左右相等，但到左边界或右边界
            if (flag2) {
                //到右边界
                if (flag1) {
                    left = 0;
                }else {
                    left++;
                }
            }

            size = right - left + 1;
            if (size > maxSize) {
                maxSize = size;
                resStr = s.substring(left, right);
            }
        }
        return resStr;
    }

    public String longestPalindrome_p(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String resultStr = "";
        
        //List<String> palList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >i; j--) {
                String subStr = s.substring(i, j);
                //判断subStr是否是回文子串
                boolean isPal = true;
                char[] charArr = subStr.toCharArray();
                /**
                if (charArr[0] == charArr[subStr.length()-1]) {
                    if (palList.contains(subStr.substring(1, subStr.length()))) {
                        palList.add(subStr);
                    }
                }
                */
                
                for (int k = 0, l = subStr.length()-1; k<l; k++, l--) {
                    if (charArr[k] != charArr[l]) {
                        isPal = false;
                        break;
                    }
                }
                 
                if (isPal && subStr.length() > resultStr.length()) {
                    resultStr = subStr;
                }
                
            }
            /**
            for (String ss : palList) {
                resultStr = ss.length() > resultStr.length() ? ss : resultStr;
            }
            */
        }
        return resultStr;
    }

    public String longestPalindrome(String s) { 
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&( j-i<3||dp[i+1][j-1]);//小于3是因为aba一定是回文
                if(dp[i][j]&&right-left<j-i){
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        LongestPalindromicStr l = new LongestPalindromicStr();
        
        System.out.println(l.longestPalindrome("c"));           //c
        System.out.println(l.longestPalindrome("ac"));          //a
        System.out.println(l.longestPalindrome(""));            // 
        System.out.println(l.longestPalindrome("babad"));       //bab
        System.out.println(l.longestPalindrome("cbbd"));        //bb
        System.out.println(l.longestPalindrome("cbbbbd"));      //bbbb
        System.out.println(l.longestPalindrome("abababa"));     //abababa
        System.out.println(l.longestPalindrome("abababab"));    //abababa
        System.out.println(l.longestPalindrome("cbbb"));        //bbb
        System.out.println(l.longestPalindrome("bbb"));         //bbb
        System.out.println(l.longestPalindrome("bbbaaaaaa"));   //aaaaaa
        System.out.println(l.longestPalindrome("bbba"));        //bbb
        System.out.println(l.longestPalindrome("abb"));         //bb
        System.out.println(l.longestPalindrome("aaaabaaa"));    //aaabaaa
        
        System.out.println(l.longestPalindrome("aba"));         //aba
        System.out.println(l.longestPalindrome("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
    }
}