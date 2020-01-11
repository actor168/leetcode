class Problem72 {
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "";
        int res = new Problem72().minDistance(word1, word2);
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        //将word2中的每个位在word1中做投影
        //对于找不到的可以做insert/replace
        //对于多余的进行删除，删除的优先级放低
        return 0;
    }
}