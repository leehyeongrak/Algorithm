class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, computers);
                answer ++;
            }
        }

        return answer;
    }

    public void dfs(int index, int[][] computers) {
        visited[index] = true;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[index][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
