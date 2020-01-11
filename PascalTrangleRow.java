import java.util.*;
class PascalTrangleRow {
    public static void main(String[] args) {
        List<Integer> res = new PascalTrangleRow().getRow(3);
        System.out.println(res.toString());
    }

    public List<Integer> getRow(int rowIndex) {
        return generateRow(rowIndex+1);
    }
    
    List<Integer> generateRow(int i) {
        List<Integer> arr = new ArrayList<>();
        if (i < 1) {
            return arr;
        }
        
        if (i == 1) {
            arr.add(1);
        } else {
            for (int k = i, j = 1; j <= i; j++) {
                int v = generateValue(k, j);
                arr.add(v);
            }
        }
        return arr;
    }

    int generateValue(int i, int j) {
        if (i == j || j == 1) {
            return 1;
        }
        return generateValue(i-1, j-1) + generateValue(i-1, j);
    }
}