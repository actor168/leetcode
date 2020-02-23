class Problem406 {
	public static void main(String[] args) {
		
	}

	public int[][] reconstructQueue(int[][] people) {
        int[][] out = new int[people.length][2];
        ArrayList<Pair> inp = new ArrayList<>();
        ArrayList<Pair> res = new ArrayList<>();
        int j = 0;
        
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        for (int[] p : people) {
            inp.add(new Pair(p[0], p[1]));
        }

        for (Pair e : inp) {
            res.add(e.pos, e);
        }

        for (Pair e : res) {
            out[j][0] = e.height;
            out[j++][1] = e.pos;
        }
        return out;
    }

}

class Pair {
	int height;
	int pos;

	public Pair(int height, int pos) {
		this.height = height;
		this.pos = pos;
	}
}