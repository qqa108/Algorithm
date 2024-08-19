import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int pre = arr[i][0];
			int count = 1;
			boolean check = true;

			for (int j = 1; j < N; j++) { // 우상향
				int dif = arr[i][j] - pre;
				if (dif >= 2) { // 높이차이가 2이상이면
					check = false;
					break;
				} else if (dif == 0) {
					count++;
				}

				else if (dif == 1) {
					if (j - X < 0 || j - 1 >= N) {
						check = false;
						break;
					} else {
						boolean b = true;
						for (int k = j - 1; k >= j - X; k--) {
							if (visit[i][k]) {
								b = false;
								break;
							}
						}
						if (count >= X && b) {
							for (int k = j - 1; k >= j - X; k--) {
								visit[i][k] = true;
							}
							pre = arr[i][j];
							count = 1;
						} else {
							check = false;
							break;
						}
					}
				}

				else if (dif == -1) {
					pre = arr[i][j];
					count = 1;
				} else {
					check = false;
					break;
				}
			}

			if (check) {
				pre = arr[i][N - 1];
				count = 1;

				for (int j = N - 2; j >= 0; j--) { // 좌상향
					int dif = arr[i][j] - pre;
					if (dif >= 2) { // 높이차이가 2이상이면
						check = false;
						break;
					} else if (dif == 0) {
						count++;
					} else if (dif == 1) {
						if (j + X >= N || j + 1 < 0) {
							check = false;
							break;
						} else {
							boolean b = true;
							for (int k = j + 1; k <= j + X; k++) {
								if (visit[i][k]) {
									b = false;
									break;
								}
							}
							if (count >= X && b) {
								for (int k = j + 1; k <= j + X; k++) {
									visit[i][k] = true;
								}
								pre = arr[i][j];
								count = 1;
							} else {
								check = false;
								break;
							}
						}
					}

					else if (dif == -1) {
						pre = arr[i][j];
						count = 1;
					} else {
						check = false;
						break;
					}
				}
			}
			if (check) {
				answer++;
			}
		}

		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int pre = arr[0][i];
			int count = 1;
			boolean check = true;

			for (int j = 1; j < N; j++) { // 하향
				int dif = arr[j][i] - pre;
				if (dif >= 2) { // 높이차이가 2이상이면
					check = false;
					break;
				} else if (dif == 0) {
					count++;
				}

				else if (dif == 1) {
					if (j - X < 0 || j - 1 >= N) {
						check = false;
						break;
					} else {
						boolean b = true;
						for (int k = j - 1; k >= j - X; k--) {
							if (visit[k][i]) {
								b = false;
								break;
							}
						}
						if (count >= X && b) {
							for (int k = j - 1; k >= j - X; k--) {
								visit[k][i] = true;
							}
							pre = arr[j][i];
							count = 1;
						} else {
							check = false;
							break;
						}
					}
				}

				else if (dif == -1) {
					pre = arr[j][i];
					count = 1;
				} else {
					check = false;
					break;
				}
			}

			if (check) {
				pre = arr[N - 1][i];
				count = 1;

				for (int j = N - 2; j >= 0; j--) { // 상향
					int dif = arr[j][i] - pre;
					if (dif >= 2) { // 높이차이가 2이상이면
						check = false;
						break;
					} else if (dif == 0) {
						count++;
					} else if (dif == 1) {
						if (j + X >= N || j + 1 < 0) {
							check = false;
							break;
						} else {
							boolean b = true;
							for (int k = j + 1; k <= j + X; k++) {
								if (visit[k][i]) {
									b = false;
									break;
								}
							}
							if (count >= X && b) {
								for (int k = j + 1; k <= j + X; k++) {
									visit[k][i] = true;
								}
								pre = arr[j][i];
								count = 1;
							} else {
								check = false;
								break;
							}
						}
					} else if (dif == -1) {
						pre = arr[j][i];
						count = 1;
					} else {
						check = false;
						break;
					}
				}
			}
			if (check) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}