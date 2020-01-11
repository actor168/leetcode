import java.util.*;

class Problem22 {
	public static void main(String[] args) {
		System.out.println(new Problem22().generateParenthesis(3).size());
	}

	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 1) {
            res.add("");
        } else {
           for (int i = 0; i < n; i++) {
           		for(String left : generateParenthesis(i)) {
           			for (String right: generateParenthesis(n-1-i)) {
           				res.add("(" + left + ")" + right);
           			}
           		}
           }
        }
        return res;
    }
}