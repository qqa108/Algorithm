import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> wlist = new ArrayList<>();
		List<Integer> hlist = new ArrayList<>();

		wlist.add(0);
		wlist.add(W);
		hlist.add(0);
		hlist.add(H);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (dir == 0) {
				hlist.add(num);
			}
			else {
				wlist.add(num);
			}
		}

		Collections.sort(wlist);
		Collections.sort(hlist);

		int wmax = 0;
		int hmax = 0;

		for (int i = 1; i < wlist.size(); i++) {
			if (wmax < wlist.get(i) - wlist.get(i - 1)) {
				wmax = wlist.get(i) - wlist.get(i - 1);
			}
		}
		for (int i = 1; i < hlist.size(); i++) {
			if (hmax < hlist.get(i) - hlist.get(i - 1)) {
				hmax = hlist.get(i) - hlist.get(i - 1);
			}
		}
		System.out.println(wmax * hmax);
		br.close();
	}
}