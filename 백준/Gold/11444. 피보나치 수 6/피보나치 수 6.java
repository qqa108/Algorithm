import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static long N;
	static long mod = 1_000_000_007;
	static Map<Long, Long> hash = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		long s = dfs(N);
		System.out.println(s % mod);
	}

	static long dfs(long n) {
		if (n <= 2) {
			return 1;
		}
		if(hash.containsKey(n)) {
			return hash.get(n);
		}
		else {
			hash.put(n, ((dfs(n - (n / 2)) % mod * dfs((n / 2) + 1) % mod) % mod
					+ (dfs(n - 1 - (n / 2)) % mod * dfs(n / 2) % mod) % mod) % mod);
		}
		return ((dfs(n - (n / 2)) % mod * dfs((n / 2) + 1) % mod) % mod
				+ (dfs(n - 1 - (n / 2)) % mod * dfs(n / 2) % mod) % mod) % mod;
	}
}