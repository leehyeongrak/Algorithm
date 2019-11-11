class Solution {
    static char[][] mat;
  public int solution(int m, int n, String[] board) {
      int answer = 0;
      mat = new char[m][n];
      for (int i = 0; i < m; i++) {
          char[] blocks = board[i].toCharArray();
          int j = 0;
          for(char c: blocks) {
              mat[i][j] = c;
              j++;
          }
      }

      boolean flag = false;
      while (flag == false) {
          boolean[][] visited = new boolean[m][n];
          flag = true;
          for (int i = 0; i < m-1; i++) {
              for (int j = 0; j < n-1; j++) {
                  char block = mat[i][j];
                  if(block == '0') {
                      continue;
                  }
                  if(mat[i+1][j] == block && mat[i][j+1] == block && mat[i+1][j+1] == block) {
                      visited[i][j] = true;
                      visited[i+1][j] = true;
                      visited[i][j+1] = true;
                      visited[i+1][j+1] = true;
                      flag = false;
                  }
              }
          }

          for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  if (visited[i][j]) {
                      answer++;
                      for (int k = i-1; k >= 0; k--) {
                          mat[k+1][j] = mat[k][j];
                          mat[k][j] = '0';
                      }
                  }
              }
          }
      }
      return answer;
  }
}
