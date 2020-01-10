import java.util.*;
class PascalTrangle {
    public static void main(String[] args) {
        List<List<Integer>> res = new PascalTrangle().generate(5);
        System.out.println(res.toString());
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        generateRow(numRows, list);
        return list;
    }

    void generateRow(int i, List<List<Integer>> list) {
        List<Integer> arr = new ArrayList<>();
        if (i < 1) {
            return;
        }
        if (i == 1) {
            arr.add(1);
            list.add(arr);
            return;
        } 
        for (int k = i, j = 1; j <= i; j++) {
            int v = generateValue(k, j);
            arr.add(v);
        }
        generateRow(i-1, list);
        list.add(arr);
        return;
    }

    int generateValue(int i, int j) {
        if (i == j || j == 1) {
            return 1;
        }
        return generateValue(i-1, j-1) + generateValue(i-1, j);
    }
}