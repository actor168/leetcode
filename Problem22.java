import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem22 {
    public static void main(String[] args) {
        System.out.println(new Problem22().generateParenthesis(3));
        System.out.println(new Problem22().generateParenthesis(4).size());
        /*


        ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
        */
    }


    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<String>();
        if (n < 1) {
            return new ArrayList<>(res);
        }

        if (n == 1) {
            res.add("()");
        } else {
            List<String> subRes = generateParenthesis(n-1);
            for (String subStr : subRes) {
                res.add("()" + subStr);
                res.add("(" + subStr + ")");
                res.add(subStr + "()");
            }
        }

        return new ArrayList<>(res);
    }
}