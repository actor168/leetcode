import java.util.ArrayList;
import java.util.Arrays;

class Permutations {

	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		int[] arr = {5,4};
		Arrays.sort(arr);

		Permutations p = new Permutations();
		
		ArrayList<Integer> k = new ArrayList<>();
		for (int v : arr) {
			k.add(v);
		}

		p.res.add(k);
		p.permutations(arr);

		System.out.println(p.res);
		System.out.println(p.res.size());
	}

	void permutations(int[] arr) {

		int n = arr.length-1;

		int i = n-1;
		while(i >= 0 && arr[i] >= arr[i+1]) {
			i--;
		}

		if (i < 0) return;

		int j = n;
		while(arr[j] <= arr[i]) {
			j--;
		}

		swap(arr, i, j);

		// 反转从end到 i之间所有的数据
		int l = i+1, r = n;
		while(l < r) {
			swap(arr, l, r);
			l++;
			r--;
		} 

		ArrayList<Integer> k = new ArrayList<>();
		for (int v : arr) {
			k.add(v);
		}

		res.add(k);
		permutations(arr);
	}

	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}