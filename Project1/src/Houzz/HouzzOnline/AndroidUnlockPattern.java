///*
// * Android Unlock Patterns
// * 1<=m<=n<=9
// */
//int[][] jumps;
//public int numOfPatterns(int m, int n) {
//	// Define jumps
//	jumps = new int[10][10];
//	initializeJumps();
//	int result = 0;
//
//	boolean[] visited = new boolean[10];
//	result += helper(1, 1, visited, m, n, 0) * 4;
//	result += helper(2, 1, visited, m, n, 0) * 4;
//	result += helper(5, 1, visited, m, n, 0);
//	return result;
//}
//private int helper(int point, int path, boolean[] visited, int m, int n, int result) {
//	if (path >= m && path <= n) {
//		result++;
//	}
//	if (path > n) {
//		return;
//	}
//	visited[point] = true;
//	// if next is valid, continue searching the path
//	for (int i = 1; i <= 9; i++) {
//		int mid = jumps[point][i];
//		if (!visited[i] && (mid == 0 || visited[mid])) {
//			helper(i, path + 1, visited, m, n, result);
//		}
//	}
//	visited[point] = false;
//}
//private void initializeJumps() {
//	jumps[1][3] = 2;
//	jumps[3][1] = 2;
//	jumps[4][6] = 5;
//	jumps[6][4] = 5;
//	jumps[7][9] = 8;
//	jumps[9][7] = 8;
//	jumps[1][7] = 4;
//	jumps[7][1] = 4;
//	jumps[2][8] = 5;
//	jumps[8][2] = 5;
//	jumps[3][9] = 6;
//	jumps[9][3] = 6;
//	jumps[1][9] = 5;
//	jumps[3][7] = 5;
//}